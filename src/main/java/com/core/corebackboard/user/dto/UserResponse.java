package com.core.corebackboard.user.dto;

import com.core.corebackboard.user.service.UserDomain;

public record UserResponse(
        Long id,
        String name,
        String email
) {

    public static UserResponse from(UserDomain domain) {
        return new UserResponse(
                domain.id(),
                domain.info().name(),
                domain.info().email()
        );
    }


}
