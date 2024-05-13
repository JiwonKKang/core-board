package com.core.corebackboard.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Slf4j
@Service
public class UserService {

    private final UserAppender userAppender;
    private final UserReader userReader;

    public Long signUp(UserInfo userInfo) {
        return userAppender.append(userInfo);
    }

    public UserDomain getUserInfo(Long userId) {
        return userReader.read(userId);
    }
}
