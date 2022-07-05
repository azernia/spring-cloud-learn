package com.rui.admin.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 系统角色权限表 DTO
 *
 * @author Rui
 * @since 2022-03-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePermissionsDTO implements Serializable {

    /**
     * ID
     */
    private Integer id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     *  权限 IDs
     */
    private List<String> permissionIds;
}
