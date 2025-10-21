package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyApp {

    public static void main(String[] args) {
        // application.properties에서 포트 설정을 읽어 8081로 실행됩니다.
        SpringApplication.run(MyApp.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "Hello from Jenkins CI/CD!";
    }
}
