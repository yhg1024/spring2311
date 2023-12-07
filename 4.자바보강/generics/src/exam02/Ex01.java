package exam02;

import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.setItem(new Apple());

        Apple apple = appleBox.getItem(); // 타입 안정성, 형변환 x

        Box<Pear> pearBox = new Box<>();
    }
}
