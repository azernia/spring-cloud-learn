package com.rui.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rui.admin.mapper.ClientMapper;
import com.rui.admin.model.entity.Client;
import com.rui.admin.service.ClientService;
import org.springframework.stereotype.Service;

/**
* 系统客户端信息 服务实现类
*
* @author Rui
* @since 2022-06-28
*/
@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements ClientService {

}
