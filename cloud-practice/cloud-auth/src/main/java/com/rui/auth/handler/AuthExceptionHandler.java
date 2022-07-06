package com.rui.auth.handler;

import com.rui.common.basic.result.RespBean;
import com.rui.common.basic.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * description: 授权异常处理
 * date: 2022/6/17 16:31
 *
 * @author rui
 */
@Slf4j
@Order(-1)
@RestControllerAdvice
public class AuthExceptionHandler {
    /**
     * 用户不存在
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UsernameNotFoundException.class)
    public RespBean<ResultCode> handleUsernameNotFoundException(UsernameNotFoundException e) {
        log.error("认证异常:{}", e.getMessage());
        return RespBean.failed(ResultCode.USER_NOT_EXIST);
    }

    /**
     * 用户名和密码异常
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidGrantException.class)
    public RespBean<ResultCode> handleInvalidGrantException(InvalidGrantException e) {
        log.error("认证异常:{}", e.getMessage());
        return RespBean.failed(ResultCode.USERNAME_OR_PASSWORD_ERROR);
    }

    /**
     * 用户名和密码异常
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidClientException.class)
    public RespBean<ResultCode> handleInvalidGrantException(InvalidClientException e) {
        log.error("认证异常:{}", e.getMessage());
        return RespBean.failed(ResultCode.CLIENT_AUTHENTICATION_FAILED);
    }


    /**
     * 账户异常(禁用、锁定、过期)
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({InternalAuthenticationServiceException.class})
    public RespBean<ResultCode> handleInternalAuthenticationServiceException(InternalAuthenticationServiceException e) {
        return RespBean.failed(e.getMessage());
    }

    /**
     * token 无效或已过期
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({InvalidTokenException.class})
    public RespBean<ResultCode> handleInvalidTokenExceptionException(InvalidTokenException e) {
        return RespBean.failed(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({Exception.class})
    public RespBean<ResultCode> handleException(Exception e) {
        log.info("系统异常{}", e);
        return RespBean.failed(e.getMessage());
    }
}
