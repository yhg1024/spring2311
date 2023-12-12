package exam01;

import java.util.Vector;

public class Ex04 {
    public static void main(String[] args) {
        Vector<String> names = new Vector<>(3);
        names.add("이름1");
        names.add("이름2");
        names.add("이름3");
        names.add("이름4"); // 내부 배열 이 새로 만들어지면서 공간이 2배가 됐다
        System.out.println("capacity : " + names.capacity());

    }
}
