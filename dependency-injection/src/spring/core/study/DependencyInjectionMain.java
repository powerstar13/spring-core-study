package spring.core.study;

import spring.core.study.di.Base64Encoder;
import spring.core.study.di.Encoder;
import spring.core.study.di.UrlEncoder;

public class DependencyInjectionMain {

    public static void main(String[] args) {

        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        // Base 64 encoding
        Encoder base64Encoder = new Encoder(new Base64Encoder()); // 외부에서 사용할 객체를 주입받는 것이 DI
        String base64Result = base64Encoder.encode(url);
        System.out.println(base64Result);

        // url encoding
        Encoder urlEncoder = new Encoder(new UrlEncoder());
        String urlResult = urlEncoder.encode(url);
        System.out.println(urlResult);
    }
}
