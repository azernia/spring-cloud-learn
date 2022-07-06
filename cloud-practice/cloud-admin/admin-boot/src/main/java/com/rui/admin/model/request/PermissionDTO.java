package com.rui.admin.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
/**
 * 权限表 DTO
 *
 * @author Rui
 * @since 2022-07-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionDTO {

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
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 创建者
     */
    private String createBy;
}
