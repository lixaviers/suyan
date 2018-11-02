package com.suyan.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:spring/applicationContext-*.xml"})
@EnableDiscoveryClient
public class GoodsWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsWebApplication.class, args);
    }
}
