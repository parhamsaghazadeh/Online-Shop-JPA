package com.parham.online_shop.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication( scanBasePackages = {"com.parham.online_shop"})
public class SBExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SBExampleApplication.class, args);
    }
}
