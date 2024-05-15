package com.core.corebackboard.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class PasswordValidator {

    public void validate(UserDomain user, String password) {
        if (!Objects.equals(user.info().password(), password)) {
            throw new IllegalArgumentException("Invalid password");
        }
    }

}
