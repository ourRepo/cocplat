package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.example")
@SpringBootApplication
public class CocplatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(CocplatformApplication.class, args);
    }

}
