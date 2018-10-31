package com.suyan.user.server.jwt;

import com.suyan.user.resp.UserODTO;
import com.suyan.user.result.UserResult;
import com.suyan.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class ServerJwtTokenEnhancer implements TokenEnhancer {

    @Autowired
    private IUserService userService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserResult<UserODTO> userResult = userService.getUserByOpenId(userDetails.getUsername());
        Map<String, Object> info = new HashMap<>();
        info.put("nickName", userResult.getDataMap().getNickName());
        info.put("openId", userResult.getDataMap().getOpenId());

        ((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(info);
        return accessToken;

    }
}
