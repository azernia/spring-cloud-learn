package com.rui.admin.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * 系统日志 DTO
 *
 * @author Rui
 * @since 2022-04-19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogDTO implements Serializable {

    /**
     * ID
     */
    private Integer id;





    /**
     * 请求地址
     */
    private String requestUrl;

    /**
     * 业务名称
     */
    private String businessName;

    /**
     * 请求方式
     */
    private String httpMethod;

    /**
     * 类名
     */
    private String className;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 请求IP
     */
    private String ip;
}
