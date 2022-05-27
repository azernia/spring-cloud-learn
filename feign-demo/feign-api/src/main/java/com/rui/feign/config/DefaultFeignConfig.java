package com.rui.feign.config;

import com.rui.feign.interceptor.FeignAuthInterceptor;
import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * create date 2022/5/23 09:49
 *
 * @author rui
 */
public class DefaultFeignConfig  {

    @Bean
    public Logger.Level logLevel() {
        return Logger.Level.BASIC;
    }

    /**
     * feign拦截器
     *
     * @return {@link FeignAuthInterceptor}
     */
    @Bean
    public FeignAuthInterceptor feignAuthInterceptor() {
        return new FeignAuthInterceptor();
    }

}
