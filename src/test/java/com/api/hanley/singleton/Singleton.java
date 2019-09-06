package com.api.hanley.singleton;

/**
 * @author hanley
 * @date 2019/6/10 11:41
 * 风萧萧兮易水寒
 */
public class Singleton {
    private String name1;
    private String name2;
    private String name3;

    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    //饿汉
    public static Singleton getSimple() {
        return instance;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public void showHW(){
        System.out.println("Hello world!");
    }

    @Override
    public String toString() {
        return "Singleton{" +
                "name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                ", name3='" + name3 + '\'' +
                '}';
    }
}
