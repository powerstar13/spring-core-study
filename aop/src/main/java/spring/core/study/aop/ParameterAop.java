package spring.core.study.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect // AOP로 동작하도록 명시
@Component // Spring에서 관리되도록 명시
public class ParameterAop {

    @Pointcut("execution(* spring.core.study.controller..*.*(..))") // @Pointcut: 어느 부분에 적용할 것인지 지정
    private void cut() {}

    @Before("cut()")
    public void before(JoinPoint joinPoint) { // JoinPoint: 들어가는 지점에 대한 정보들을 가지고 있는 객체
        System.out.println("===== Before =====");

        // 메서드 정보 가져오기
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("method = " + method.getName());

        // 매개 변수 정보 가져오기
        Object[] args = joinPoint.getArgs(); // 메서드에 들어가는 매개 변수들에 대한 배열을 가져온다.

        for (Object obj : args) {
            System.out.println("type = " + obj.getClass().getSimpleName()); // 매개 변수의 자료형
            System.out.println("value = " + obj); // 매개 변수의 값
        }
    }

    @AfterReturning(value = "cut()", returning = "obj")
    public void afterReturn(JoinPoint joinPoint, Object obj) {
        System.out.println("===== AfterReturning =====");
        System.out.println("obj = " + obj);
    }
}
