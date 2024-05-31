package com.core.corebackboard.user.service;

import com.core.corebackboard.user.entity.User;
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

    public UserDomain readByName(String username) {
        return userRepository.findByUsername(username);
    }
}
