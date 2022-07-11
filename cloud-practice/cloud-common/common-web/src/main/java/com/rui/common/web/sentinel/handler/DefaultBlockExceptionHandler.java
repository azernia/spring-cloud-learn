package com.rui.common.web.sentinel.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rui.common.basic.result.RespBean;
import com.rui.common.basic.result.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

/**
 * description: 默认阻塞异常处理器
 * <hr/>
 * date: 2022/7/11 13:50
 *
 * @author rui
 */
@Component
public class DefaultBlockExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
        response.setStatus(HttpStatus.OK.value());
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        // 流控
        if (e instanceof FlowException) {
            objectMapper.writeValue(response.getWriter(), RespBean.failed(ResultCode.FLOW_LIMITING));
            // 降级
        } else if (e instanceof DegradeException) {
            objectMapper.writeValue(response.getWriter(), RespBean.failed(ResultCode.DEGRADATION));
            // 未授权
        } else if (e instanceof AuthorityException) {
            objectMapper.writeValue(response.getWriter(), RespBean.failed(ResultCode.ACCESS_UNAUTHORIZED));
        }
    }
}
