package exam05;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class Ex01 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 7, 8, 9, 10};
        int[] nums2 = Arrays.stream(nums).filter(x -> x % 2 == 1).toArray();
    }
}
