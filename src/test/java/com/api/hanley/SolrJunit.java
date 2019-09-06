package com.api.hanley;

import com.alibaba.fastjson.JSONObject;
import com.api.hanley.entity.dto.Customer;
import com.api.hanley.service.impl.SolrjServiceImpl;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author hanley
 * @date 2019/8/20 17:39
 * 风萧萧兮易水寒
 */
public class SolrJunit {

    /*private SolrjServiceImpl solrjService;

    private HttpSolrServer httpSolrServer;

    @Before
    public void setUp() throws Exception {
        // 在url中指定core名称：bwie
        String url = "http://192.168.1.157:8983/solr/customer";
        HttpSolrServer httpSolrServer = new HttpSolrServer(url); //定义solr的server
        httpSolrServer.setParser(new XMLResponseParser()); // 设置响应解析器
        httpSolrServer.setMaxRetries(1); // 设置重试次数，推荐设置为1
        httpSolrServer.setConnectionTimeout(500); // 建立连接的最长时间

        this.httpSolrServer = httpSolrServer;
        solrjService = new SolrjServiceImpl(httpSolrServer);
    }

    @Test
    public void testAdd() throws Exception {
        Customer customer = new Customer();
        customer.setId(System.currentTimeMillis());
        customer.setCustomerName("我是中国上海人");
        customer.setCreateDate(new Date());
        customer.setCustomerAddress("上海宝山淞南镇长江南路");
        customer.setCustomerMail("18946fwef1654165@163.com");
        customer.setCustomerPhone("123456798");
        customer.setUpdateTime(new Date());
        this.solrjService.add(customer);
    }

    @Test
    public void testDelete() throws Exception {
        this.solrjService.delete(Arrays.asList("1566296650950","1566295702375"));
    }

    @Test
    public void testSearch() throws Exception {
        //<Foo> foos = this.solrjService.search("*",1, 10);//查询全部
        //List<Foo> foos = this.solrjService.search("成长",1, 10);
        List<Customer> list = this.solrjService.search("","",1, 10);
        for (Customer stu : list) {
            System.out.println(JSONObject.toJSONString(stu));
        }
    }

    @Test
    public void testDeleteByQuery() throws Exception{
        httpSolrServer.deleteByQuery("*:*");
        httpSolrServer.commit();
    }*/



}
