package com.api.hanley.controller;

import com.alibaba.fastjson.JSONObject;
import com.api.hanley.entity.dto.Customer;
import com.api.hanley.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @author hanley
 * @date 2019/8/21 13:39
 * 风萧萧兮易水寒
 */
@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/addTosolr")
    @ResponseBody
    public String addTosolr()throws Exception{
        long start = System.currentTimeMillis();
         customerService.addTosolr();
        long end = System.currentTimeMillis();
        return "success!导入数据耗费"+(end-start)+"ms";
    }

    @RequestMapping(value = "/delSolrById")
    @ResponseBody
    public String delSolrById(long id)throws Exception{
        long start = System.currentTimeMillis();

        customerService.delete(Arrays.asList(String.valueOf(id)));
        long end = System.currentTimeMillis();
        return "success!导入数据耗费"+(end-start)+"ms";
    }

    @RequestMapping(value = "/search")
    @ResponseBody
    public String search(String keywords,Integer page,Integer rows)throws Exception{
        long start = System.currentTimeMillis();

        //String keywords,String customerName,Integer page, Integer rows
        List<Customer> list =  customerService.search(keywords, "", page,  rows);
        long end = System.currentTimeMillis();

        /*StringBuilder sb = new StringBuilder();
        for (Customer customer:list) {
            sb = sb.append("<p>").append(JSONObject.toJSONString(customer)).append("</p>");
        }

        return "<p>耗时"+(end-start)+"ms </p>"+sb;*/
        return "<p>耗时"+(end-start)+"ms </p>"+list.toString();
    }

}
