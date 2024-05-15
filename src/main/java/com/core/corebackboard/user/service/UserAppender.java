package com.core.corebackboard.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAppender {

    private final UserRepository userRepository;

    public Long append(UserInfo userInfo) {
        return userRepository.save(userInfo);
    }
}
