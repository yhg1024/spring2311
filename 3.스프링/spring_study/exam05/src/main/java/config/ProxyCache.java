package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Order(1)
public class ProxyCache {

    private Map<Long, Object> cacheData = new HashMap<>();

    /*@Pointcut("execution(* aopex..*(long))") // 포인트컷만 따로빼서 쓰는 경우도 있다.
    public void publicTarget() {}*/

    @Around("config.CommonPointcut.publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws  Throwable {

        Object[] args = joinPoint.getArgs(); // 매개변수로 투입된 인자 값( 예 - 10L)
        Long num = (Long) args[0];
        if(cacheData.containsKey(num)) {
            System.out.println("캐시값 사용");
            return  cacheData.get(num);
        }

        Object result = joinPoint.proceed(); // ProxyCalculator::proceed() 핵심기능 대신 수행

        // 캐시 저장
        cacheData.put(num, result);
        System.out.println("캐시 저장");

        return result;
    }
}
