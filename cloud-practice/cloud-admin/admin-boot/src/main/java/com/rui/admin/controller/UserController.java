package com.rui.admin.controller;

import com.rui.admin.service.UserService;
import com.rui.api.model.request.UserDTO;
import com.rui.common.basic.result.RespBean;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 用户 Controller
 * <hr/>
 * date: 2022/7/6 11:44
 *
 * @author rui
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/getUserByUsername/{username}")
    RespBean<UserDTO> getUserByUsername(@PathVariable("username") String username) {
        return RespBean.success(userService.getUserByUsername(username));
    }

}
