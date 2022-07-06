package com.rui.admin.listener;

import com.rui.admin.service.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * description: 资源权限监听器
 * <hr/>
 * date: 2022/7/5 17:10
 *
 * @author rui
 */
@Component
@AllArgsConstructor
public class ResourcePermissionCatchListener implements CommandLineRunner {

    private final PermissionService permissionService;

    @Override
    public void run(String... args) {
        permissionService.refreshPermission();
    }
}
