package com.rui.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * create date 2022/5/20 16:59
 *
 * @author rui
 */
@Data
@Component
@ConfigurationProperties(prefix = "pattern")    // 约定大于配置
public class PatternProperties {

    private String dateformat;

}
