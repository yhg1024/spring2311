package exam01;

public class Ex03 {
    public static void main(String[] args) {
        int num1 = 100;
        Integer num2 = new Integer(200);

        int num3 = num1 + num2;
        // 정수형 int와 참조형 Integer는 달라서 원래 안되는데
        // num2.intValue() - 컴파일러에서 자동 추가

        System.out.println(num3);

        Integer num4 = num3; // Integer.valueof(num3) - 컴파일러가 자동 추가
    }
}
