package exam01;

import java.util.Stack;

public class Ex03 {
    public static void main(String[] args) {
        Stack<String> names = new Stack<>();
        names.push("이름1"); // 마지막에 추가한걸 먼저 꺼내는 구조
        names.push("이름2");
        names.push("이름3");

        System.out.println(names.pop());
        System.out.println(names.pop());
        System.out.println(names.pop());
    }
}
