package com.rui.admin.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 权限表 VO
 *
 * @author Rui
 * @since 2022-07-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionVO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 菜单模块ID
     */
    private Integer menuId;

    /**
     * URL权限标识
     */
    private String urlPerm;

    /**
     * 角色编码集合
     */
    private List<String> roleCodes;

}
