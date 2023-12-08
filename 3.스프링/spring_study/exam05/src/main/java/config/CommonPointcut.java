package config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CommonPointcut {
    @Pointcut("execution(* aopex..*(long))") // 포인트컷만 따로빼서 쓰는 경우도 있다.
    public void publicTarget() {}
}
