package com.exmaple.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(value = {"com.example.frontend"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
