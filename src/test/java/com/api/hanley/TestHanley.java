package com.api.hanley;

/**
 * @author hanley
 * @date 2019/4/26 17:26
 * 风萧萧兮易水寒
 */
public class TestHanley {
    public static void main(String[] args){
        //得到类的简写名称
        System.out.println(TestHanley.class.getSimpleName());

        //得到对象的全路径
        System.out.println(TestHanley.class);

        //得到对象的类模板示例，也就是Class
        System.out.println(TestHanley.class.getClass());

        //得到Class类的名称
        System.out.println(TestHanley.class.getClass().getName());
    }
}
