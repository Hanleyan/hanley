package com.api.hanley.service.impl;

import com.api.hanley.dao.CustomerMapper;
import com.api.hanley.entity.dto.Customer;
import com.api.hanley.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author hanley
 * @date 2019/8/21 14:06
 * 风萧萧兮易水寒
 */
@Slf4j
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerMapper customerMapper;

    // 定义http的solr服务
    @Autowired
    private SolrClient httpSolrServer;



    /**
     * 新增数据到solr服务
     *
     * @param
     * @throws Exception
     */
    public void add(Customer customer) throws Exception {
        this.httpSolrServer.addBean(customer); //添加数据到solr服务器
        this.httpSolrServer.commit(); //提交
    }

    public void delete(List<String> ids) throws Exception {
        this.httpSolrServer.deleteById(ids);
        this.httpSolrServer.commit(); //提交
    }

    public List<Customer> search(String keywords,String customerName,Integer page, Integer rows) throws Exception {
        SolrQuery solrQuery = new SolrQuery(); //构造搜索条件
        // solrQuery.setQuery("jiguan:" + keywords+" AND name:"+name); //搜索关键词
        if(StringUtils.isEmpty(keywords)){
            keywords = "*";
        }
        solrQuery.setQuery("customerName:" + keywords); //搜索关键词
        //solrQuery.setQuery("name:"+name);
        // 设置分页 start=0就是从0开始，，rows=5当前返回5条记录，第二页就是变化start这个值为5就可以了。
        int num=(Math.max(page, 1) - 1) * rows;
        System.out.println(num);
        solrQuery.setStart(num);
        solrQuery.setRows(rows);

/* // 创建组合条件串
    StringBuilder params = new StringBuilder("productType:" + productType);

    // 组合商品颜色条件
    if (color != null) {
        params.append(" AND color:" + color);
    }

    // 组合价格区间条件
    if (minPrice.intValue() != 0 || maxPrice != 0) {
        params.append(" AND spPrice:[" + minPrice + " TO "
                + maxPrice + "]");
    }

    solrQuery.setQuery(params.toString());  */

        //是否需要高亮
        boolean isHighlighting = !StringUtils.equals("*", keywords) && StringUtils.isNotEmpty(keywords);

        if (isHighlighting) {
            // 设置高亮
            solrQuery.setHighlight(true); // 开启高亮组件
            solrQuery.addHighlightField("customerName");// 高亮字段
            solrQuery.setHighlightSimplePre("<em style='color: red;'/>");// 标记，高亮关键字前缀
            solrQuery.setHighlightSimplePost("</em>");// 后缀
        }

        // 执行查询
        QueryResponse queryResponse = this.httpSolrServer.query(solrQuery);
        List<Customer> list = queryResponse.getBeans(Customer.class);
        if (isHighlighting) {
            // 将高亮的标题数据写回到数据对象中
            Map<String, Map<String, List<String>>> map = queryResponse.getHighlighting();
            for (Map.Entry<String, Map<String, List<String>>> highlighting : map.entrySet()) {
                for (Customer foo : list) {
                    //判断主键相等
                    if (!highlighting.getKey().equals(String.valueOf(foo.getId()))) {
                        continue;
                    }
                    foo.setCustomerName(StringUtils.join(highlighting.getValue().get("customerName"), ""));
                    break;
                }
            }
        }

        return list;
    }

    /**
     * 批量导入数据库customer表的数据进solr
     * @return
     */
    public void addTosolr()throws Exception{
        long i = 0;


        List<Customer> list = customerMapper.selectAllLimit(15000,85000);// 0 -- 10000 10000-15000  --->15000 100000
        for (Customer customer:list) {
            //Customer customer = customerMapper.selectByPrimaryKey(1);
            this.add(customer);
            i++;
            log.info("导入第"+i+"个数据成功。");
        }

        // 100000 200000 300000 400000 50 60 70 80 90 100 110 120 130 140 150 160 170 180 190 2000000
        for (int j = 0; j < 19; j++) {
            int l1 = 100000 * (j+1);
            int l2 = 100000;
            List<Customer> customerList = customerMapper.selectAllLimit(l1,l2);// 100000
            for (Customer customer:customerList) {
                //Customer customer = customerMapper.selectByPrimaryKey(1);
                this.add(customer);
            }
            log.info("j:"+j+", l1:"+l1+", l2:"+l2+",完毕。");

        }

    }
}
