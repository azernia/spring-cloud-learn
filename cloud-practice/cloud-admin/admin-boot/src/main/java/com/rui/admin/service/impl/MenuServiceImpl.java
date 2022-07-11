package com.rui.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rui.admin.mapper.MenuMapper;
import com.rui.admin.model.entity.Menu;
import com.rui.admin.service.MenuService;
import org.springframework.stereotype.Service;

/**
 * description: 菜单 Service 实现
 * <hr/>
 * date: 2022/7/7 15:11
 *
 * @author rui
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
}
