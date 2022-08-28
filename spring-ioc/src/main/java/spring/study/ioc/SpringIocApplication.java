package spring.study.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import spring.study.ioc.container.ApplicationContextProvider;
import spring.study.ioc.di.Base64Encoder;
import spring.study.ioc.di.Encoder;
import spring.study.ioc.di.UrlEncoder;

@SpringBootApplication // 스프링 컨테이너 안에서 관리되는 객체들을 Bean이라고 부른다.
public class SpringIocApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIocApplication.class, args);

        ApplicationContext context = ApplicationContextProvider.getContext();

//        Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
//        UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);

//        Encoder encoder = context.getBean(Encoder.class); // Encoder 클래스의 생성자에서 @Qualifier 애노테이션을 통해 어떤 Bean을 사용할지 지정했음
        Encoder encoder = context.getBean("urlEncoderBean", Encoder.class); // Bean의 이름을 직접 명시하여 가져올 수 있다. AppConfig에서 등록한 Bean 참고

        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        String result = encoder.encode(url);
        System.out.println(result);
    }

}
