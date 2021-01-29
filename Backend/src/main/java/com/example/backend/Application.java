package com.example.backend;

import com.example.backend.annotations.LogMethodCall;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    @LogMethodCall("")
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
