package spring.study.ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.study.ioc.di.Base64Encoder;
import spring.study.ioc.di.Encoder;
import spring.study.ioc.di.UrlEncoder;

@Configuration // @Configuration 애노테이션은 한 개의 클래스에서 여러 개의 Bean을 등록하겠다는 뜻이다.
public class AppConfig {

    @Bean("base64EncoderBean") // Encoder라는 Bean이 2개 이상일 경우 @Bean 애노테이션에 이름을 지정하여 구분할 수 있다.
    public Encoder encoder(Base64Encoder base64Encoder) {
        return new Encoder(base64Encoder);
    }

    @Bean("urlEncoderBean")
    public Encoder encoder(UrlEncoder urlEncoder) {
        return new Encoder(urlEncoder);
    }
}
