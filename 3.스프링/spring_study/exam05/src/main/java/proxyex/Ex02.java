package proxyex;

public class Ex02 {
    public static void main(String[] args) {
        ProxyCalculator cal1 = new ProxyCalculator(new ImpCalculator());
        long result1 = cal1.factorial(10L);
        System.out.printf("cal1 : %d%n", result1);

        ProxyCalculator cal2 = new ProxyCalculator(new RecCalculator());
        long resut2 = cal2.factorial(10L);
        System.out.printf("cal2 : %d%n", resut2);
    }
}
