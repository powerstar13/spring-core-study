package spring.core.study.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {

    @Pointcut("execution(* spring.core.study.controller..*.*(..))")
    private void cut() {}

    @Pointcut("@annotation(spring.core.study.annotation.Timer)") // 커스텀 애노테이션을 Pointcut에 전달
    private void enableTimer() {}

    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("===== Around =====");

        StopWatch stopWatch = new StopWatch(); // Spring에서 시간을 기록하는 객체를 제공한다.
        stopWatch.start();

        Object result = joinPoint.proceed(); // 메서드가 반환하는 값을 가져온다.

        stopWatch.stop();

        System.out.println("total time: " + stopWatch.getTotalTimeSeconds());
    }
}
