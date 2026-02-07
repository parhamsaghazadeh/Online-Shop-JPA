package com.parham.online_shop.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@SpringBootApplication(scanBasePackages = {
        "com.parham.online_shop.controller",
        "com.parham.online_shop.service",
        "com.parham.online_shop.repository",
        "com.parham.online_shop.model"
})
@ComponentScan({"com.parham.online_shop.controller" , "com.parham.online_shop.service" , "com.parham.online_shop.repository"
, "com.parham.online_shop.model" , "com.parham.online_shop.factory"})
@EntityScan("com.parham.online_shop.entity")
@EnableJpaRepositories("com.parham.online_shop.repository")
@Configuration
public class SBExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SBExampleApplication.class, args);
    }
}
