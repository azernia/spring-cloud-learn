package com.rui.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rui.user.mapper.UserMapper;
import com.rui.user.pojo.User;
import com.rui.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * create date 2022/5/20 11:13
 *
 * @author rui
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
