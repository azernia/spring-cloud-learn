package com.rui.admin.controller;

import com.rui.admin.model.entity.Menu;
import com.rui.admin.service.MenuService;
import com.rui.common.basic.result.RespBean;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description: 菜单 Controller
 * <hr/>
 * date: 2022/7/7 15:13
 *
 * @author rui
 */
@RestController
@RequestMapping("/menu")
@AllArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/menuList")
    public RespBean<List<Menu>> getMenuList() {
        return RespBean.success(menuService.list());
    }

}
