package com.rui.admin.service.impl;

import com.rui.admin.model.entity.User;
import com.rui.admin.mapper.UserMapper;
import com.rui.admin.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* 系统用户 服务实现类
*
* @author Rui
* @since 2022-03-16
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
