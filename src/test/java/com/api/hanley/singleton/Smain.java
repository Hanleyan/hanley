package com.api.hanley.singleton;

/**
 * @author hanley
 * @date 2019/6/10 11:44
 * 风萧萧兮易水寒
 */
public class Smain {
    public static void main(String[] args) {
        /*Simple.getSimple().showHW();
        Simple.getSimple().showHW();
        Simple.getSimple().showHW();*/

        Singleton.getSimple().setName1("Name1");
        System.out.println(Singleton.getSimple().toString());
        Singleton.getSimple().setName2("Name2");
        System.out.println(Singleton.getSimple().toString());
        Singleton.getSimple().setName3("Name3");
        System.out.println(Singleton.getSimple().toString());
    }
}
