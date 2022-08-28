package spring.study.ioc.di;

import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Component
public class UrlEncoder implements IEncoder {

    @Override
    public String encode(String message) {
        return URLEncoder.encode(message, StandardCharsets.UTF_8);
    }
}
