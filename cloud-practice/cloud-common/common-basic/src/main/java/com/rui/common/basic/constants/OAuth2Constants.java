package com.rui.common.basic.constants;

/**
 * description: OAuth2 常量
 * <hr/>
 * date: 2022/6/27 13:43
 *
 * @author rui
 */
public interface OAuth2Constants {

    String CLIENT_ID = "rui";

    String RESOURCE_IDS = "";

    String SCOPE_ALL = "all";

    String SCOPES = SCOPE_ALL;

    String GRANT_TYPE_PASSWORD = "password";

    String GRANT_TYPE_CLIENT_CREDENTIALS = "client_credentials";

    String REFRESH_TOKEN = "refresh_token";

    String AUTHORIZATION_CODE = "authorization_code";

    String REDIRECT_URI = "https://www.baidu.com";

    String AUTHORITIES = "";

    String GRANT_TYPES = GRANT_TYPE_PASSWORD + "," +
            GRANT_TYPE_CLIENT_CREDENTIALS + "," +
            REFRESH_TOKEN + "," +
            AUTHORIZATION_CODE;
}
