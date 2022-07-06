package com.rui.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rui.admin.model.entity.Client;
import com.rui.admin.service.ClientService;
import com.rui.api.model.request.ClientDTO;
import com.rui.common.basic.result.RespBean;
import com.rui.common.basic.utils.BeanCopyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * description: 客户端 Controller
 * <hr/>
 * date: 2022/7/6 11:15
 *
 * @author rui
 */
@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("getClientByClientId")
    RespBean<ClientDTO> getClientByClientId(@RequestParam String clientId) {
        Client client = clientService.getOne(new LambdaQueryWrapper<Client>().eq(Client::getClientId, clientId));
        if (Objects.isNull(client)) {
            throw new RuntimeException("client not found");
        }
        return RespBean.success(BeanCopyUtils.copyBean(client, ClientDTO.class));
    }
}
