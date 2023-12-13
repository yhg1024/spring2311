package exam01;

import java.util.function.Function;

public class Ex08 {
    public static void main(String[] args) {
        // 문자가 들어오면 문자의 길이를 반환한다.
        Function<String, Integer> func1 = s -> s.length();

        // 숫자가 들어오면 3제곱해서 반환한다.
        Function<Integer, Integer> func2 = x -> x * x * x;

        Function<String, Integer> func3 = func1.andThen(func2);

        int num = func3.apply("ABC");
        System.out.println(num);

        Function<Integer, Integer> func4 = x -> x;
        Function<Integer, Integer> func5 = Function.identity(); // 항등함수
    }
}
