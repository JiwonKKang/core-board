package com.core.corebackboard.user.dto;

import com.core.corebackboard.user.service.UserInfo;

public record SignUpRequest(
        String username,
        String password,
        String email
) {

    public UserInfo toUserInfo() {
        return new UserInfo(
                email,
                password,
                username
        );
    }
}
