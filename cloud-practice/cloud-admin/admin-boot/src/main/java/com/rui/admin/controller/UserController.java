package com.rui.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rui.admin.model.entity.User;
import com.rui.admin.service.UserService;
import com.rui.api.model.request.UserDTO;
import com.rui.common.basic.result.RespBean;
import com.rui.common.basic.utils.BeanCopyUtils;
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
        User user = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username));
        return RespBean.success(BeanCopyUtils.copyBean(user, UserDTO.class));
    }

}
