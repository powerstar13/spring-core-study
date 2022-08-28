package spring.study.ioc.di;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component // 이름을 지정 안하면 클래스의 이름을 소문자로 시작하여 반영된다. ex) Base64Encoder -> base64Encoder
//@Component("baseEncoder") // 직접 빈의 이름을 등록할 수도 있다.
public class Base64Encoder implements IEncoder {

    @Override
    public String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
