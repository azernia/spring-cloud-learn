package com.rui.admin.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 角色用户关联表 VO
 *
 * @author Rui
 * @since 2022-03-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleUserVO implements Serializable {

    /**
     * ID
     */
    private Integer id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 用户ID
     */
    private Integer userId;
}
