package com.rui.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * create date 2022/5/19 17:50
 *
 * @author rui
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaDemoApplication.class, args);
    }
}
