package com.api.hanley.controller;

import com.alibaba.fastjson.JSON;
import com.api.hanley.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hanley
 * @date 2019/4/25 15:04
 * 风萧萧兮易水寒
 */
@Slf4j
@Controller
@RequestMapping(value = "/redis")
@ResponseBody
public class RedisController {

    /*@Autowired
    RedisService redisService;

    @RequestMapping(value = "/setOnly")
    public boolean domeSetTest(String key,String value){
        boolean b = redisService.set(key,value);
        return b;
    }
    @RequestMapping(value = "/getOnly")
    public Object domeSetTest(String key){
        Object o = redisService.get(key);
        return o;
    }

    @RequestMapping(value = "/set")
    public String domeSetTest(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            redisService.set(String.valueOf(i),"bibibaba"+i,100000);
        }
        long end = System.currentTimeMillis();
        long temp = end - start;

        return "执行了"+temp+"毫秒！";  //执行了8627070毫秒！  两个多小时
    }
    @RequestMapping(value = "/get")
    public Object domeGetTest(){
        long start = System.currentTimeMillis();
        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < 100000; i++) {
            Object o = redisService.get(String.valueOf(i));
            list.add(o);
        }
        long end = System.currentTimeMillis();
        long temp = end - start;

        return "结果："+JSON.toJSON(list)+"\n"+"执行了"+temp+"毫秒！";  //执行了3303280毫秒！ 0.9小时
    }
    @RequestMapping(value = "/getById/{id}")
    public Object domeGetTest(@PathVariable int id){
        long start = System.currentTimeMillis();

        Object o = redisService.get(String.valueOf(id));

        long end = System.currentTimeMillis();
        long temp = end - start;

        return "结果："+JSON.toJSON(o)+"\n"+"执行了"+temp+"毫秒！";
    }*/
}
