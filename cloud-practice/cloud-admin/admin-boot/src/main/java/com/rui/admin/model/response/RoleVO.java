package com.rui.admin.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 系统角色 VO
 *
 * @author Rui
 * @since 2022-03-22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleVO implements Serializable {

    /**
     * ID
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色中文名
     */
    private String nameZh;

    /**
     * 是否被禁用
     */
    private Boolean enable;
}
