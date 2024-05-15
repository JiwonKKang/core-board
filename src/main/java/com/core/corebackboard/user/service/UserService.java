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
    private final PasswordValidator passwordValidator;

    public Long signUp(UserInfo userInfo) {
        return userAppender.append(userInfo);
    }

    public UserDomain login(String email, String password) {
        UserDomain user = userReader.read(email);
        passwordValidator.validate(user, password);
        return user;
    }
}
