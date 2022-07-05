package com.rui.admin.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * 系统角色权限表 VO
 *
 * @author Rui
 * @since 2022-03-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePermissionsVO implements Serializable {

    /**
     * ID
     */
    private Integer id;





    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 权限标识
     */
    private String authority;
}
