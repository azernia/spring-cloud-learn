package com.rui.api.feign;

import com.rui.api.model.request.UserDTO;
import com.rui.common.basic.result.RespBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * description: 用户 Feign 客户端
 * <hr/>
 * date: 2022/7/1 17:45
 *
 * @author rui
 */
@FeignClient("cloud-admin")
public interface UserFeignClient {
    @GetMapping("/api/user/getUserByUsername/{username}")
    RespBean<UserDTO> getUserByUsername(@PathVariable("username") String username);
}
