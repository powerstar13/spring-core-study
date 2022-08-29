package spring.core.study.controller;

import org.springframework.web.bind.annotation.*;
import spring.core.study.annotation.Decode;
import spring.core.study.annotation.Timer;
import spring.core.study.dto.User;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {

        System.out.println("===== GET method =====");

        return id + " " + name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user) {

        System.out.println("===== POST method =====");

        return user;
    }

    @Timer // 직접 만든 애노테이션 사용
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {

        // DB logic
        Thread.sleep(2000);
    }

    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user) {

        System.out.println("===== PUT method =====");

        return user;
    }
}
