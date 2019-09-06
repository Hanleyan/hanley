package com.api.hanley;

import com.alibaba.fastjson.JSON;

/**
 * @author hanley
 * @date 2019/6/17 11:22
 * 风萧萧兮易水寒
 */
public class TestClass {

    private String name;

    public static void main(String[] args) {
        System.out.println("Test你好");
        System.out.println(CalssA.uname);
    }

    static class CalssA{
        static String uname = "xyz";

        static {
            System.out.println("xyz静态块");
        }

        public CalssA() {
            System.out.println("Test CalssA你好");
        }
    }
}
