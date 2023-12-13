package exam05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Ex06 {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        Collections.addAll(strs, "a", "b", "c", "d");

        Collections.shuffle(strs); // 무작위로 섞어줌

        System.out.println(strs);

        System.out.println(Collections.max(strs)); // 정렬 후 -> 가장 끝 요소
        System.out.println(Collections.min(strs)); // 정렬 후 -> 가장 앞 요소


    }
}
