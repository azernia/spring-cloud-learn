package com.rui.auth.client;

import com.rui.auth.enums.PasswordEncoderTypeEnum;
import com.rui.common.basic.constants.OAuth2Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

/**
 * description:
 * date: 2022/6/17 14:48
 *
 * @author rui
 */
@Service
@RequiredArgsConstructor
public class ClientDetailsServiceImpl implements ClientDetailsService {
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        //TODO: 后面通过feign从管理端获取，目前写死
        BaseClientDetails clientDetails = new BaseClientDetails(
                OAuth2Constants.CLIENT_ID,
                OAuth2Constants.RESOURCE_IDS,
                OAuth2Constants.SCOPES,
                OAuth2Constants.GRANT_TYPES,
                OAuth2Constants.AUTHORITIES,
                OAuth2Constants.REDIRECT_URI

        );
        clientDetails.setClientSecret(PasswordEncoderTypeEnum.NOOP.getPrefix() + "rui");
        clientDetails.setAccessTokenValiditySeconds(3600);
        clientDetails.setRefreshTokenValiditySeconds(36000000);
        return clientDetails;
    }
}
