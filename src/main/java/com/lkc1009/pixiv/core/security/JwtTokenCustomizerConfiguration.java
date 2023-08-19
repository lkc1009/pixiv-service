package com.lkc1009.pixiv.core.security;

import com.lkc1009.pixiv.core.security.service.OidcUserInfoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.endpoint.OidcParameterNames;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenCustomizer;

@Configuration
public class JwtTokenCustomizerConfiguration {
    @Bean
    public OAuth2TokenCustomizer<JwtEncodingContext> tokenCustomizer(OidcUserInfoService oidcUserInfoService) {
        return (context -> {
           if (!AuthorizationGrantType.CLIENT_CREDENTIALS.equals(context.getAuthorizationGrantType())) {
               if (OidcParameterNames.ID_TOKEN.equals(context.getTokenType().getValue()) || OAuth2TokenType.ACCESS_TOKEN.equals(context.getTokenType())) {
                   OidcUserInfo oidcUserInfo = oidcUserInfoService.oidcUserInfo(context.getPrincipal().getName());
                   context.getClaims().claims(claims -> claims.putAll(oidcUserInfo.getClaims()));
                   context.getJwsHeader().type("jwt");
               }
           }
        });
    }
}
