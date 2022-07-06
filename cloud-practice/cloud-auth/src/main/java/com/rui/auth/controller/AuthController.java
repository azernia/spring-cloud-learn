package com.rui.auth.controller;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.rui.common.basic.result.RespBean;
import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import java.security.KeyPair;
import java.security.Principal;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * description:
 * date: 2022/6/17 15:24
 *
 * @author rui
 */
@RestController
@AllArgsConstructor
@RequestMapping("/oauth")
public class AuthController {

    private final TokenEndpoint tokenEndpoint;

    private final KeyPair keyPair;

    /**
     * 手动实现 /oauth/token
     * 覆盖原方法
     */
    @PostMapping("/token")
    public RespBean<OAuth2AccessToken> postAccessToken(
            Principal principal,
            @RequestParam Map<String, String> parameters
    ) throws HttpRequestMethodNotSupportedException {
        OAuth2AccessToken accessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
        return RespBean.success(accessToken);
    }

    @GetMapping("/public-key")
    public Map<String, Object> getPublicKey() {
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey rsaKey = new RSAKey.Builder(publicKey).build();
        return new JWKSet(rsaKey).toJSONObject();
    }

}
