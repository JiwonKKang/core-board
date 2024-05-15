package com.core.corebackboard.user.api;

public record LoginRequest(
        String email,
        String password
) {
}
