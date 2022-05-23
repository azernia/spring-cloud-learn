package com.rui.order;

import com.rui.feign.clients.UserClient;
import com.rui.feign.config.DefaultFeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * create date 2022/5/20 11:24
 *
 * @author rui
 */
@EnableFeignClients(defaultConfiguration = DefaultFeignConfig.class, clients = {UserClient.class})
// @EnableFeignClients
@MapperScan("com.rui.order.mapper")
@SpringBootApplication
public class OrderFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignApplication.class, args);
    }
}
