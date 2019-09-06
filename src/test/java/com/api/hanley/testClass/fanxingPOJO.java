package com.api.hanley.testClass;


/**
 * @author hanley
 * @date 2019/6/19 13:43
 * 风萧萧兮易水寒
 *
 * 泛型类
泛型类的声明和非泛型类的声明类似，除了在类名后面添加了类型参数声明部分。

和泛型方法一样，泛型类的类型参数声明部分也包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。因为他们接受一个或多个参数，这些类被称为参数化的类或参数化的类型。

实例
如下实例演示了我们如何定义一个泛型类:
 */
public class fanxingPOJO<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        fanxingPOJO<String> fanxingPOJO = new fanxingPOJO<>();
        fanxingPOJO<Integer> fanxingPOJONum = new fanxingPOJO<>();
        fanxingPOJO.setT("hello");
        fanxingPOJONum.setT(23);
        System.out.println(fanxingPOJO.getT());
        System.out.println(fanxingPOJONum.getT());

    }
}
