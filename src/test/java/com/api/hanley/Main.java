package com.api.hanley;

/**
 * @author hanley
 * @date 2019/7/8 15:24
 * 风萧萧兮易水寒
 */

public class Main {
        public static void main(String[] args) {
            Person p = new Student();
            p.run(); // 应该打印Person.run还是Student.run?
        }
    }

    class Person {
        public void run() {
            System.out.println("Person.run");
        }
    }

    class Student extends Person {
        @Override
        public void run() {
            System.out.println("Student.run");
        }
}
