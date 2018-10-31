package com.suyan.mmc.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ImportResource({"classpath:spring/applicationContext-*.xml"})
@EnableDiscoveryClient
@EnableScheduling // 开启定时任务
public class MmcJobApplication {
    public static void main(String[] args) {
        SpringApplication.run(MmcJobApplication.class, args);
    }
}
