package com.api.hanley.simple;

/**
 * @author hanley
 * @date 2019/6/10 10:28
 * 风萧萧兮易水寒
 *
 * 懒汉
 */
public class Simple {

    private String name1;
    private String name2;
    private String name3;

    private static Simple simple = null;

    private Simple() {
    }

    //双检锁/双重校验锁（DCL，即 double-checked locking）
    /*public static Simple getSimple() {
        if(simple == null){
            synchronized (Simple.class){
                if(simple == null){
                    simple = new Simple();
                }
            }
        }
        return simple;
    }*/

    //懒汉式，线程安全
    public static synchronized Simple getSimple() {
        if(simple == null){
            simple = new Simple();
        }
        return simple;
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
        return "Simple{" +
                "name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                ", name3='" + name3 + '\'' +
                '}';
    }
}
