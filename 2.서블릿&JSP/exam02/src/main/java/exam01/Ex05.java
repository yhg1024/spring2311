package exam01;

import static java.lang.System.identityHashCode;

public class Ex05 {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2);
        System.out.println("str1 : " + identityHashCode(str1));
        System.out.println("str2 : " + identityHashCode(str2));

        int num1 = 10;
        int num2 = 10;
        System.out.println(num1 == num2);
    }

}
