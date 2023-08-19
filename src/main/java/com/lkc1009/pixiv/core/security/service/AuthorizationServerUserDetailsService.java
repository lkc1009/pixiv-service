package com.lkc1009.pixiv.core.security.service;

import com.lkc1009.pixiv.core.security.user.User;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorizationServerUserDetailsService implements UserDetailsService {
    private static final String WAYNE_ID = "c52bf7db-db55-4f89-ac53-82b40e8c57c2";
    private static final String KENT_ID = "52a14872-ba6b-488f-aa4d-453b11f9ddce";
    private static final String PARKER_ID = "3a73ef49-c671-4d66-b6f2-7725ccde5c2b";

    private final PasswordEncoder passwordEncoder;
    private final Map<String, User> userMap = new HashMap<>();

    @PostConstruct
    private void initUserMap() {
        Set<String> bWayneRoles = new HashSet<>();
        bWayneRoles.add("USER");
        User bWayne = new User(UUID.fromString(WAYNE_ID), "bwayne", passwordEncoder.encode("wayne"),
                "Bruce", "Wayne", "bruce.wayne@example.com", bWayneRoles);
        Set<String> cKentRoles = new HashSet<>();
        cKentRoles.add("USER");
        User cKent = new User(UUID.fromString(KENT_ID), "ckent", passwordEncoder.encode("kent"),
                "Clark", "Kent", "clark.kent@example.com", cKentRoles);
        Set<String> pParkerRoles = new HashSet<>();
        pParkerRoles.add("USER");
        pParkerRoles.add("ADMIN");
        User pParker = new User(UUID.fromString(PARKER_ID), "pparker", passwordEncoder.encode("parker"),
                "Peter", "Parker", "peter.parker@example.com", pParkerRoles);
        userMap.put("bwayne", bWayne);
        userMap.put("ckent", cKent);
        userMap.put("pparker", pParker);

        log.info("Initialized users {}, {} and {}", bWayne, cKent, pParker);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (userMap.containsKey(username)) {
            log.info("Found user for {}", username);
            return userMap.get(username);
        } else {
            log.warn("No user found for {}", username);
            throw new UsernameNotFoundException("No user found for " + username);
        }
    }
}
