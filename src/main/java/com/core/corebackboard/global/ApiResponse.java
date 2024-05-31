package com.core.corebackboard.global;

import com.core.corebackboard.global.exception.ErrorCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private String responseCode;

    private String message;

    private T result;

    public ApiResponse(String responseCode, T result) {
        this.responseCode = responseCode;
        this.result = result;
    }

    public ApiResponse(String responseCode, String message) {
        this.responseCode = responseCode;
        this.message = message;
    }

    public static <T> ApiResponse<T> success(T result) {
        return new ApiResponse<>("SUCCESS", result);
    }

    public static ApiResponse<Void> success() {
        return new ApiResponse<>("SUCCESS", null);
    }

    public static ApiResponse<Void> success(String message) {
        return new ApiResponse<>("SUCCESS", message);
    }

    public static ApiResponse<Void> error(ErrorCode errorCode, String message) {
        return new ApiResponse<>(errorCode.name(), message, null);
    }
}
