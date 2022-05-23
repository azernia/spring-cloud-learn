package com.rui.order;

import com.rui.order.config.DefaultFeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * create date 2022/5/20 11:24
 *
 * @author rui
 */
@EnableFeignClients(defaultConfiguration = DefaultFeignConfig.class)
@MapperScan("com.rui.order.mapper")
@SpringBootApplication
public class OrderFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignApplication.class, args);
    }
}
