package com.rui.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description: Admin Application
 * <hr/>
 * date: 2022/7/5 17:08
 *
 * @author rui
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.rui.admin.mapper"})
@EnableDiscoveryClient
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
