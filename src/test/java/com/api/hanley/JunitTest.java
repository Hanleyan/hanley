package com.api.hanley;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.junit.Test;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

/**
 * @author hanley
 * @date 2019/6/10 10:27
 * 风萧萧兮易水寒
 */
public class JunitTest {

    @Test
    public void test1(){
        double d = 0.0;

        double car_price = 11 ;
        double payment = 10 ;
        int periods = 36;
        double sp_rate = 11 ;

        double rz = car_price*(1-payment/100.0);
        double mi = Math.pow(1+sp_rate/100/12,periods);
        d = rz*sp_rate/100 / 12 * mi/(mi-1);
        System.out.println(d);

    }
    @Test
    public void test2() throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2019-04-04 15:00:00");
        int periods = 2;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, periods);

        String current = simpleDateFormat.format(calendar.getTime());
        System.out.println(current);

        Date fur = simpleDateFormat.parse(current);
        Boolean b = false;//分期已结束
        if(System.currentTimeMillis() < fur.getTime()){
            b = true; //分期未结束
        }
        System.out.println(b);

    }
    @Test
    public void test3() throws Exception{
        Double d = 0.015980*3+0.014268*6+0.016381*6+0.005821*2+0.003158*6+0.005821*6+0.003158*6+0.001586*1+0.005289*1;
        System.out.println(d);
    }
    @Test
    public void test4()throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = simpleDateFormat.parse("2018-04-12");
        Date toDate = simpleDateFormat.parse("2019-05-13");

        Calendar  from  =  Calendar.getInstance();
        from.setTime(fromDate);
        Calendar  to  =  Calendar.getInstance();
        to.setTime(toDate);
        //int fromYear = from.get(Calendar.YEAR);
        int fromMonth = from.get(Calendar.MONTH);
        int fromDay = from.get(Calendar.DAY_OF_MONTH);
        //int toYear = to.get(Calendar.YEAR);
        int toMonth = to.get(Calendar.MONTH);
        int toDay = to.get(Calendar.DAY_OF_MONTH);
        //int year = toYear  -  fromYear;
        int month = toMonth  - fromMonth;
        int day = toDay  - fromDay;

        System.out.println(" month:"+month+" day:"+day);
    }
/**
 * 从Java 8之后，Java里面添加了许多的新特性，其中一个最常见也是最实用的便是日期处理的类——LocalDate。
 新增的日期jar主要有三种：
 java.time.LocalDate  ->只对年月日做出处理
 java.time.LocalTime  ->只对时分秒纳秒做出处理
 java.time.LocalDateTime ->同时可以处理年月日和时分秒
 ---------------------
 作者：怀英兄
 来源：CSDN
 原文：https://blog.csdn.net/u011055819/article/details/80070429
 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
    /**
     * 再也不为日期烦恼——LocalDate的使用
     */
    @Test
    public void test5(){
        // 获取今天的日期
        LocalDate today = LocalDate.now();
        // 今天是几号
        int dayofMonth = today.getDayOfMonth();
        // 今天是周几（返回的是个枚举类型，需要再getValue()）
        int dayofWeek = today.getDayOfWeek().getValue();
        // 今年是哪一年
        int dayofYear = today.getDayOfYear();

        // 根据字符串取：
        LocalDate endOfFeb = LocalDate.parse("2018-02-28");
        // 严格按照yyyy-MM-dd验证，02写成2都不行，当然也有一个重载方法允许自己定义格式

        System.out.println("today:"+today);
        System.out.println("dayofMonth:"+dayofMonth);
        System.out.println("dayofWeek:"+dayofWeek);
        System.out.println("dayofYear:"+dayofYear);
        System.out.println("endOfFeb:"+endOfFeb);
    }

    @Test
    public void test6() throws Exception{
        String loanTime = "2019-07-03";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long loanTimeL = simpleDateFormat.parse(loanTime).getTime();
        long today = simpleDateFormat.parse(simpleDateFormat.format(new Date())).getTime();
        if(loanTimeL < today){
            System.out.println("不能选择小于今天的日期");
        }else {
            System.out.println("ok");
        }
    }
    @Test
    public void test7(){
        String returnDay = "60";
        boolean boll = returnDay.matches("[0-9]+");//纯数字true  否false
        System.out.println(boll);
    }
    @Test
    public void test8(){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        System.out.println(str);
        // 去掉"-"符号
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        System.out.println(temp);
    }
    @Test
    public void test9(){
        String returnDay = "hello";
        String s = returnDay.toUpperCase();//大写
        System.out.println(returnDay);
        System.out.println(s);
        String low= s.toLowerCase();//小写
        System.out.println(low);
    }
    @Test
    public void test10(){
        StringBuilder sb = new StringBuilder(1024);
        for (int i = 0; i < 5000; i++) {
            sb.append(",");
            sb.append(i);
        }
        System.out.println(sb);
    }
    @Test
    public void test11(){
        BigInteger n = new BigInteger("9").pow(3);//幂运算
        float f = n.floatValue();
        System.out.println(f);

        //[10,50)的随机整数
        for (int i = 0; i < 100; i++) {
            double a = Math.random() * 40 + 10 ;
            System.out.println((long)a);
        }
    }
    @Test
    public void test12()throws Exception{
        Date d = new Date();
        Gson gson = new Gson();
        System.out.println(gson.toJson(d));
        System.out.println(JSON.toJSONString(d));

        Date date = new Date(System.currentTimeMillis());
        System.out.println(gson.toJson(date));

    }

    @Test
    public void test13()throws Exception{
        Integer[] inArr = {1,2,3,4};
        String[] strArr = {"1","2","3","4"};

        int[] in = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
                in[i] = Integer.parseInt( strArr[i]);
        }
        System.out.println(in.length);

        String d = "[\"10\",\"15\",\"0\",\"5\"]";
        JSONArray arr  = JSONArray.parseArray(d);
        List l = JSONArray.parseArray(d);
        System.out.println(arr.size());
        System.out.println(l);

        String[] strings = {"12","24","36"};
        System.out.println(JSONObject.toJSONString(strings));

    }

    @Test
    public void compMap(){
        Map<String,Object> hashMap = new HashMap<String,Object>();
        hashMap.put("a","");
        hashMap.put("b","b");
        hashMap.put("a",165);
        System.out.println(JSONObject.toJSONString(hashMap));
    }

    @Test
    public void time(){
        //Date d = new Date("1562515200000");
        Date d = new Date(1565193600000l);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(d);
        System.out.println(str);
    }
}
