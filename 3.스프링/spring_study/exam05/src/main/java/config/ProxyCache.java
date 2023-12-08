package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class ProxyCache {

    private Map<Long, Long> cacheData = new HashMap<>();

    @Pointcut("execution(* aopex..*(long))")
    public void publicTarget() {}

    @Around("publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws  Throwable {

        Object[] args = joinPoint.getArgs(); // 매개변수로 투입된 인자 값( 예 - 10L)
        Long num = (Long) args[0];
        if(cacheData.containsKey(num)) {
            return  cacheData.get(num);
        }

        Object result = joinPoint.proceed(); // 핵심기능 대신 수행

        return result;
    }
}
