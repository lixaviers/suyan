package com.suyan.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:spring/spring-*.xml"})
@EnableDiscoveryClient
public class UserRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserRestApplication.class, args);
    }
}
