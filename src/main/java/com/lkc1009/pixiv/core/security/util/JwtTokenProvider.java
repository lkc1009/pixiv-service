package com.lkc1009.pixiv.core.security.util;

import com.lkc1009.pixiv.core.security.properties.TokenSecretProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private final TokenSecretProperties tokenSecretProperties;
}
