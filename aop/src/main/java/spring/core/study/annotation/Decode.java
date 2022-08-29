package spring.core.study.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD}) // 어디에 사용할 것인지 명시
@Retention(RetentionPolicy.RUNTIME) // Runtime 시 사용할 것을 명시
public @interface Decode { // 커스텀 애노테이션 정의
}
