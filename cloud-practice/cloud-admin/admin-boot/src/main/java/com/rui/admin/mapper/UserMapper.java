package com.rui.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rui.admin.model.entity.User;
import com.rui.api.model.request.UserDTO;
import org.apache.ibatis.annotations.Param;

/**
 * 用户信息表 Mapper 接口
 *
 * @author Rui
 * @since 2022-07-06
 */
public interface UserMapper extends BaseMapper<User> {

    UserDTO getUserByUsername(@Param("username") String username);
}
