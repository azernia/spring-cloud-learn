package com.rui.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * create date 2022/5/20 11:09
 *
 * @author rui
 */
@MapperScan("com.rui.user.mapper")
@SpringBootApplication
public class UserGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserGatewayApplication.class, args);
    }
}
