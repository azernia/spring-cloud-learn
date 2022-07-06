package com.rui.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rui.admin.model.entity.User;
import com.rui.api.model.request.UserDTO;

/**
 * 用户信息表 服务类
 *
 * @author Rui
 * @since 2022-07-06
 */
public interface UserService extends IService<User> {

    UserDTO getUserByUsername(String username);
}
