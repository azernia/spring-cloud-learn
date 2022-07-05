package com.rui.admin.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.rui.common.basic.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
/**
 * 角色用户关联表
 *
 * @author Rui
 * @since 2022-03-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role_user")
public class RoleUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
    * ID
    */
    @TableId(value = "id", type = IdType.AUTO)
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
