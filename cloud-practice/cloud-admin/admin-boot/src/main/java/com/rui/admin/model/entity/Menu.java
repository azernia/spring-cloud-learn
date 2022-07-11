package com.rui.admin.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * description: 系统菜单
 * <hr/>
 * date: 2022/7/7 14:42
 *
 * @author rui
 */
@Data
@TableName("sys_menu")
public class Menu {

    private Long id;

    private String name;

    private Long parentId;

    private String path;

    private String component;

    private String icon;

    private Integer sort;

    private Boolean visible;

}
