package exam02;

import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>(); // 실행될떄(객체를 만들때) Apple로 변경
        appleBox.setItem(new Apple());

        Apple apple = appleBox.getItem(); // 타입 안정성, 형변환 x

        Box<Pear> pearBox = new Box<>();
    }
}
