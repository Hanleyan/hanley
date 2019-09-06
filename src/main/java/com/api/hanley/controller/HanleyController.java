package com.api.hanley.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author hanley
 * @date 2019/4/23 13:21
 * 风萧萧兮易水寒
 */
@Slf4j
@Controller
@RequestMapping(value = "/main")
public class HanleyController {

    @RequestMapping(value = "/str")
    @ResponseBody
    public String putOutString(String string){
        log.info("string"+string);

        Map map = new HashMap();
        map.put(string,string);
        Gson gson = new Gson();
        String str = gson.toJson(map);


        return str;

    }
    @RequestMapping(value = "/aa")
    @ResponseBody
    public Map toMap(int i){
        log.info("i"+i);
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int j = 0; j < i; j++) {
            map.put(j,j);
        }
        return map;
    }
    @RequestMapping(value = "/toList")
    @ResponseBody
    public Object toList(int i){
        Gson gson = new Gson();

        log.info("i"+i);
        Integer[] array = new Integer[i];

        for (int j = 0; j < i; j++) {
            array[j] = j;
        }
        String arrayStr = Arrays.toString(array);
        arrayStr = arrayStr.substring(1,arrayStr.length()-1);

        List<String> list = Arrays.asList(arrayStr);
        return gson.toJson(list);
        //return JSON.toJSONString(list);

    }

    @RequestMapping(value = "/aajsp")
    public String toaajsp(int i){
       log.info("i="+i);
       return "/app/aa";
    }
    @RequestMapping(value = "/index")
    public String index(int i){
        log.info("i="+i);
        return "/index";
    }

    @RequestMapping ( "testRequestHeader" )
    public String testRequestHeader(@RequestHeader( "Host" ) String hostAddr, @RequestHeader String Host, @RequestHeader String host ) {
        System. out .println(hostAddr + "-----" + Host + "-----" + host );
        return "/app/aa" ;
    }

    @RequestMapping (value= "testParams" , params={ "param1=value1" , "param2" , "!param3" })
    public String testParams() {
        System. out .println( "test Params..........." );
        return "/app/aa" ;
    }

    @RequestMapping (value= "testMethod" , method={RequestMethod.DELETE,RequestMethod.GET })
    public String testMethod() {
        return "/app/aa" ;
    }
    @RequestMapping (value= "getLocation")
    public String getLocation() {
        return "/getLocation" ;
    }
}
