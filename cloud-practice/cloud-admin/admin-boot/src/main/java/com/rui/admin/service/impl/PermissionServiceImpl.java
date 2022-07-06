package com.rui.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rui.admin.model.entity.Permission;
import com.rui.admin.mapper.PermissionMapper;
import com.rui.admin.model.response.PermissionVO;
import com.rui.admin.service.PermissionService;
import com.rui.common.basic.constants.GlobalConstants;
import com.rui.common.redis.utils.RedisUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* 权限表 服务实现类
*
* @author Rui
* @since 2022-07-06
*/
@Service
@AllArgsConstructor
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    private final RedisUtils redisUtils;

    @Override
    public List<PermissionVO> getSysPermissions() {
        return baseMapper.getSysPermissions();
    }

    @Override
    public void refreshPermission() {
        redisUtils.del(GlobalConstants.URL_PERM_ROLES_KEY);
        Map<String, Object> urlMapRoles = getSysPermissions().stream().collect(Collectors.toMap(PermissionVO::getUrlPerm, PermissionVO::getRoleCodes));
        redisUtils.hashSetByKeys(GlobalConstants.URL_PERM_ROLES_KEY, urlMapRoles);
    }
}
