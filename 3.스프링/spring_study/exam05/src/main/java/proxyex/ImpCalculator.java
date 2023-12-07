package proxyex;

public class ImpCalculator implements Calculator{

    @Override
    public long factorial(long num) {

        long total = 1L;

        for (long i = 1; i <= num; i++){
            total *= i;
        }

        return total;
    }
}
