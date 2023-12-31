package main;

import models.Greeter;

import java.lang.reflect.Method;

public class Ex02 {
    public static void main(String[] args) {
        Class cls = Greeter.class;
        // 클래스의 정보가 담겨있는 객체

        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        int result = add(10, 20);
        int result2 = add(30, 40);
    }

    // 함수는 상수와 같이 처리한다.
    public static int add(int num1, int num2) {
        return  num1 + num2;
    }
}