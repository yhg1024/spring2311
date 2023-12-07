package proxyex;

public class Ex01 {
    public static void main(String[] args) {
        long stime = System.nanoTime(); // 공통 기능

        // 핵심 기능
        ImpCalculator cal1 = new ImpCalculator();
        long result1 = cal1.factorial(10);
        System.out.printf("cal1 : %d%n", result1);

        long etime = System.nanoTime(); // 공통 기능
        System.out.printf("걸린시간 : %d%n", etime - stime);


        stime = System.nanoTime(); // 공통 기능

        // 핵심 기능
        RecCalculator cal2 = new RecCalculator();
        long result2 = cal2.factorial(10);
        System.out.printf("cal2 : %d%n", result2);

        etime = System.nanoTime();
        System.out.printf("걸린시간 : %d%n", etime - stime);
    }
}
