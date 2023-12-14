package exam01;

import java.util.Arrays;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        String[] words = {"aaa", "aaa", "bb", "cc", "abcd", "abcd"};
        // 중복은 제거하고 3자 이상만 추출

        Arrays.stream(words)
                .distinct().filter(s -> s.length() >= 3).forEach(System.out::println);

        List<String> words2 = Arrays.asList("aaa", "aaa", "bb", "cc", "abcd", "abcd");
        words2.stream()
                .distinct().filter(s -> s.length() >= 3).forEach(System.out::println);
    }
}
