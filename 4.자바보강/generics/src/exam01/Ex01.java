package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Box box = new Box();
        box.setItem(new Apple()); // 1. 형변환의 번거로움

        Object obj = box.getItem();
        if (obj instanceof Apple) { // 2. 타입 안정선이 떨어진다.
            Apple apple = (Apple) obj;
        }

    }
}
