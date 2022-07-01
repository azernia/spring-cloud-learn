package com.rui.api.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 系统用户 VO
 *
 * @author Rui
 * @since 2022-03-16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO implements Serializable {

    /**
     * ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别 0-男 1-女
     */
    private Integer gender;

    /**
     * 出身日期
     */
    private LocalDateTime birthday;

    /**
     * 电话
     */
    private String phone;

    /**
     * 住址
     */
    private String address;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 是否允许
     */
    private Boolean enable;

    /**
     * 用户角色列表
     */
    private List<String> roles;
}
