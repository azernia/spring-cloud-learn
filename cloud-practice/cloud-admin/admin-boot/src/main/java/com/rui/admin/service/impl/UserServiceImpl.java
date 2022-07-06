package com.rui.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rui.admin.mapper.UserMapper;
import com.rui.admin.model.entity.User;
import com.rui.admin.service.UserService;
import org.springframework.stereotype.Service;

/**
* 用户信息表 服务实现类
*
* @author Rui
* @since 2022-07-06
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
