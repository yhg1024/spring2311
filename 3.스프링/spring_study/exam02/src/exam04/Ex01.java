package exam04;

public class Ex01 {
    public static void main(String[] args) {
        SimpleCalculator cal = new SimpleCalculator();
        int result = cal.add(10,20);
        System.out.println(result);

        // Calculator.num = 20; 정적 상수
        int result2 = cal.minus(20,10);
        System.out.println(result2);
    }
}
