package com.rui.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rui.admin.commons.constants.RespConstants;
import com.rui.admin.commons.entity.PageResult;
import com.rui.common.basic.result.RespBean;
import com.rui.admin.commons.enums.ServerExceptionEnum;
import com.rui.admin.commons.exception.BusinessException;
import com.rui.admin.commons.utils.BeanCopyUtils;
import com.rui.admin.commons.utils.PageUtils;
import com.rui.admin.mapper.RoleMapper;
import com.rui.admin.model.entity.Role;
import com.rui.admin.system.model.request.RoleDTO;
import com.rui.admin.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* 系统角色 服务实现类
*
* @author Rui
* @since 2022-03-22
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public PageResult<Role> pageList(RoleDTO roleDTO) {
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
        if (ObjectUtil.isNotNull(roleDTO.getName())) {
            queryWrapper.like(Role::getName, roleDTO.getName());
        }
        return new PageResult<>(page(PageUtils.defaultPage(), queryWrapper));
    }

    @Override
    public RespBean list(RoleDTO roleDTO) {
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
        if (ObjectUtil.isNotNull(roleDTO.getName())) {
            queryWrapper.like(Role::getName, roleDTO.getName());
        }
        return RespBean.success(list(queryWrapper));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public RespBean add(RoleDTO roleDTO) {
        Role role = BeanCopyUtils.copyBean(roleDTO, Role.class);
        if (save(role)) {
            return RespBean.success(RespConstants.ADD_SUCCESS);
        } else {
            throw new BusinessException(RespConstants.ADD_FAIL);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public RespBean edit(RoleDTO roleDTO) {
        Role role = getById(roleDTO.getId());
        if (ObjectUtil.isNull(role)) {
            throw new BusinessException(ServerExceptionEnum.NOT_EXIST.getDesc());
        }
        CopyOptions copyOptions = CopyOptions.create().setEditable(Role.class).ignoreNullValue();
        BeanUtil.copyProperties(roleDTO, role, copyOptions);
        if (updateById(role)) {
            return RespBean.success(RespConstants.UPDATE_SUCCESS);
        } else {
            throw new BusinessException(RespConstants.UPDATE_FAIL);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public RespBean delete(Integer id) {
        if (removeById(id)) {
            return RespBean.success(RespConstants.DELETE_SUCCESS);
        } else {
            throw new BusinessException(RespConstants.DELETE_FAIL);
        }
    }
}
