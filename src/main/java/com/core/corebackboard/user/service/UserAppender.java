package com.core.corebackboard.user.service;

import com.core.corebackboard.user.entity.User;
import com.core.corebackboard.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAppender {

    private final UserRepository userRepository;

    public Long append(UserInfo userInfo) {
        User user = User.builder()
                .name(userInfo.name())
                .email(userInfo.email())
                .password(userInfo.password())
                .build();

        User saved = userRepository.save(user);
        return saved.getId();
    }
}
