package cn.itcast.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * create date 2022/5/20 09:52
 *
 * @author rui
 */
@Configuration
public class EurekaConfig {
    // 使 SpringBoot 支持发送 HTTP 请求
    @Bean
    @LoadBalanced   // 负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // 自定义 Ribbon 负载均衡规则
    // @Bean
    // public IRule iRule() {
    //     return new RandomRule();
    // }
}
