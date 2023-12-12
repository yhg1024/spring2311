package exam01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ex07 {
    public static void main(String[] args) {
        // 다형성을 위해 앞에는 그냥 List로 정의한다.
        // List<String> names = new ArrayList<>();
        Queue<String> names = new LinkedList<>();
        names.add("이름1");
        names.add("이름2");
        names.add("이름3");
        names.add("이름4");

        // E poll() : 가장 앞쪽 요소를 꺼내기
        System.out.println(names.poll());
        System.out.println(names.poll());
        System.out.println(names.poll());
        System.out.println(names.poll());
    }
}
