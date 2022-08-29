package spring.core.study.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import spring.core.study.dto.User;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    @Pointcut("execution(* spring.core.study.controller..*.*(..))")
    private void cut() {}

    @Pointcut("@annotation(spring.core.study.annotation.Decode)")
    private void enableDecode() {}

    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {

            if (arg instanceof User) { // 객체가 User인 경우

                User user = User.class.cast(arg); // User로 다운캐스팅
                String base64Email = user.getEmail(); // 이메일 추출
                String email = new String(Base64.getDecoder().decode(base64Email), StandardCharsets.UTF_8); // base64 디코딩
                user.setEmail(email); // 디코딩된 이메일 반영
            }
        }
    }

    @AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {

        if (returnObj instanceof User) {

            User user = User.class.cast(returnObj); // User로 다운캐스팅
            String email = user.getEmail(); // 이메일 추출
            String base64Email = Base64.getEncoder().encodeToString(email.getBytes()); // base64 인코딩
            user.setEmail(base64Email); // 인코딩된 이메일 반영
        }
    }
}
