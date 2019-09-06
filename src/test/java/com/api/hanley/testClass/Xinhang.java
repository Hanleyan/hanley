package com.api.hanley.testClass;

import com.alibaba.fastjson.JSON;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author hanley
 * @date 2019/6/17 11:52
 * 风萧萧兮易水寒
 */
public class Xinhang {

    private String name;
    private int age;

    public Xinhang(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args)throws Exception {
        Xinhang xinhang = new Xinhang("hanley",24);
        Class clazz = xinhang.getClass();
        System.out.println("clazz.getSimpleName()："+clazz.getSimpleName());
        System.out.println("clazz.getName():"+clazz.getName());
        //System.out.println("clazz.getMethods()；"+ JSON.toJSONString(clazz.getMethods()));
        System.out.println(" clazz.getDeclaredFields():"+ JSON.toJSONString(clazz.getDeclaredFields()));
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String key = field.getName();
            PropertyDescriptor descriptor = new PropertyDescriptor(key, clazz);
            Method method = descriptor.getReadMethod();
            Object value = method.invoke(xinhang);

            System.out.println(key + ":" + value);

        }
    }


}
