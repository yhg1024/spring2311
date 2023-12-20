package exam04;

import java.util.Arrays;

public class Ex03{
    public static void main(String[] args) {
        int[] nums = {22, 5, 99, 1, 67};

        int min = Arrays.stream(nums).reduce(Integer.MAX_VALUE, (a, b) -> a > b ? b : a);
        System.out.println(min);
    }
}
