package com.api.hanley;

/**
 * @author hanley
 * @date 2019/6/28 11:32
 * 风萧萧兮易水寒
 */
public class Java8Test {
    public static void main(String[] args) {
        Java8Test java8Test = new Java8Test();

        //声明类型
        MathOperation addition = (int a,int b) -> a + b;

        //不声明类型
        MathOperation subtraction  = (a,b) -> a - b;

        //大括号中的返回语句
        MathOperation multiplication  = (int a,int b) -> {
            return a * b;
        };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = "+java8Test.operate(10,5,addition));
        System.out.println("10 - 5 = "+java8Test.operate(10,5,subtraction));
        System.out.println("10 * 5 = "+java8Test.operate(10,5,multiplication));
        System.out.println("10 / 5 = "+java8Test.operate(10,5,division));

        GreetingService gs1 = (String message) -> System.out.println("hello:"+message);
        gs1.sayMessage("YSL");

        GreetingService gs2 = (message) -> System.out.println("hello:"+message);
        gs2.sayMessage("HL");

        GreetingService gs3 = message -> System.out.println("hello:"+message);
        gs3.sayMessage("YH");

    }

    private int operate(int a ,int b,MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }


    interface MathOperation{
        int operation(int a , int b);
    }
    interface GreetingService {
        void  sayMessage(String message);
    }
}
