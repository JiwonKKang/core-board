package com.core.corebackboard.user.service;

import com.core.corebackboard.util.JwtTokenUtil;
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

    public String login(String email, String password) {
        UserDomain user = userReader.read(email);
        passwordValidator.validate(user, password);
        return JwtTokenUtil.generateAccessToken(user.info().name());
    }
}
