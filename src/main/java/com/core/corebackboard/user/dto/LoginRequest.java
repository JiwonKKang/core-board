package com.core.corebackboard.user.dto;

public record LoginRequest(
        String email,
        String password
) {
}
