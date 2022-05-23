package com.rui.user.controller;

import com.rui.user.pojo.User;
import com.rui.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create date 2022/5/20 11:14
 *
 * @author rui
 */
@RestController
@RequestMapping("/user")
// @RefreshScope
public class UserController {
    private final UserService userService;

    // @Value("${pattern.dateformat}") //从 nacos 读取配置
    // private String dateformat;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }
}
