package com.lkc1009.pixiv.core.security.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class TokenSecretProperties {
    private String secret;
    private Long accessToken;
    private Long refreshToken;
}
