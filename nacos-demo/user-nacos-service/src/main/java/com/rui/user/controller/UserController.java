package com.rui.user.controller;

import com.rui.user.config.PatternProperties;
import com.rui.user.pojo.User;
import com.rui.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    private final PatternProperties patternProperties;

    // @Value("${pattern.dateformat}") //从 nacos 读取配置
    // private String dateformat;

    @Autowired
    public UserController(UserService userService, PatternProperties patternProperties) {
        this.userService = userService;
        this.patternProperties = patternProperties;
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @GetMapping("/now")
    public String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternProperties.getDateformat()));
    }

    @GetMapping("/prop")
    public PatternProperties prop() {
        return patternProperties;
    }
}
