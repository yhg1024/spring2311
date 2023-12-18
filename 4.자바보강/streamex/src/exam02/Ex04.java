package exam02;

import java.util.Random;

public class Ex04 {
    public static void main(String[] args) {
        Random rand = new Random();
        // rand.ints().limit(10).forEach(System.out::println); // 갯수 제한
        rand.ints(10).forEach(System.out::println);
    }
}
