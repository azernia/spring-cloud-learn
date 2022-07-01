package com.rui.api.feign;

import com.rui.api.model.request.ClientDTO;
import com.rui.common.basic.result.RespBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * description: OAuth Feign 客户端
 * <hr/>
 * date: 2022/7/1 17:41
 *
 * @author rui
 */
@FeignClient(value = "cloud-admin", contextId = "oauth-client")
public interface OAuthClientFeignClient {
    @GetMapping("/api/oauth-client/getClientByClientId")
    RespBean<ClientDTO> getClientByClientId(@RequestParam String clientId);
}
