package com.api.hanley.simple;

/**
 * @author hanley
 * @date 2019/6/10 10:46
 * 风萧萧兮易水寒
 */
public class Main {

    public static void main(String[] args) {
        /*Simple.getSimple().showHW();
        Simple.getSimple().showHW();
        Simple.getSimple().showHW();*/

        Simple.getSimple().setName1("Name1");
        System.out.println(Simple.getSimple().toString());
        Simple.getSimple().setName2("Name2");
        System.out.println(Simple.getSimple().toString());
        Simple.getSimple().setName3("Name3");
        System.out.println(Simple.getSimple().toString());
    }
}
