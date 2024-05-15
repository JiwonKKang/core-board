package com.core.corebackboard.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserReader {

    private final UserRepository userRepository;

    public UserDomain read(Long userId) {

        return userRepository.findByUserId(userId);
    }

    public UserDomain read(String email) {
        return userRepository.findByEmail(email);
    }

}
