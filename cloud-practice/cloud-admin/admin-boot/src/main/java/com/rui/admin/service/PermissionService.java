package com.rui.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rui.admin.model.entity.Permission;
import com.rui.admin.model.response.PermissionVO;

import java.util.List;

/**
 * 权限表 服务类
 *
 * @author Rui
 * @since 2022-07-06
 */
public interface PermissionService extends IService<Permission> {

    List<PermissionVO> getSysPermissions();

    void refreshPermission();

}
