package spring.core.study.controller;

import org.springframework.web.bind.annotation.*;
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
}
