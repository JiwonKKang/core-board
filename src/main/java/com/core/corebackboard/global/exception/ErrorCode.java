package com.core.corebackboard.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, "Invalid password"),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "Token is invalid"),
    UNAUTHORIZED_USER(HttpStatus.UNAUTHORIZED, "Unauthorized user"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"),;

    private final HttpStatus status;
    private final String message;
}
