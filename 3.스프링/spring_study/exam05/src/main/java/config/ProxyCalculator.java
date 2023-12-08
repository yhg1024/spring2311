package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import proxyex.Calculator;

@Aspect
@Order(2)
public class ProxyCalculator {

    /*@Pointcut("execution(* aopex..*(..))")
    public void publicTarget() {}

    @Around("publicTarget()")*/
    @Around("CommonPointcut.publicTarget()")//("execution(* aopex..*(..))")  위에처럼 하지 않고 이처럼 직접 할 수도 있다.
    public Object process(ProceedingJoinPoint joinPoint) throws  Throwable{

        // Signature sig = joinPoint.getSignature();
        // System.out.println(sig.toLongString());
        // System.out.println("프록시");
        // Object[] args = joinPoint.getArgs();
        // long num = (long) args[0];

        long stime = System.nanoTime(); // 공통기능

        try {
            Object result = joinPoint.proceed(); // 핵심 기능을 대신 수행하는 메서드
                // factorial(...) 함수를 불러온다.
            return result;
        }finally {
            long etime = System.nanoTime(); // 공통기능
            System.out.printf("걸린시간 : %d%n", etime - stime);
        }
    }
}
