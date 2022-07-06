package com.rui.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rui.admin.model.entity.Permission;
import com.rui.admin.model.response.PermissionVO;

import java.util.List;

/**
 * 权限表 Mapper 接口
 *
 * @author Rui
 * @since 2022-07-06
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    List<PermissionVO> getSysPermissions();
}
