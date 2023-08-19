package com.lkc1009.pixiv.core.security.service;

import com.lkc1009.pixiv.core.security.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OidcUserInfoService {
    private final AuthorizationServerUserDetailsService authorizationServerUserDetailsService;

    public OidcUserInfo oidcUserInfo(String username) {
        User user = (User) authorizationServerUserDetailsService.loadUserByUsername(username);
        return OidcUserInfo.builder()
                .subject(user.getIdentifier().toString())
                .name(user.getFirstName() + " " + user.getLastName())
                .givenName(user.getFirstName())
                .familyName(user.getLastName())
                .nickname(username)
                .preferredUsername(username)
                .profile("http://127.0.0.1/pixiv/doc.html")
                .website("http://127.0.0.1/pixiv/doc.html")
                .email(user.getEmail())
                .emailVerified(true)
                .claim("roles", user.getRoles())
                .zoneinfo("Asia/Shanghai")
                .locale("zh-CN")
                .updatedAt("2023-08-17")
                .build();
    }
}
