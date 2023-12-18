package main;

public class MethodEx01 {
    public static void main(String[] args) {
        int x = 3;
       int y = oper(x);
        System.out.println(y);

        int num1 = 10;
        int num2 = 20;
        int result = num1 + num2;

        int result2 = add(num1, num2);
    }

    // int x,y -> 지역변수
    static int oper(int x) { // 메서드
        int y = x * 2 + 1;

        return y;
    }

    static int add(int num1, int num2) { // 메서드
        int result = num1 + num2;

        return result;
    }
}
