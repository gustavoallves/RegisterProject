package com.example.registerspring.common.exception;

public record ErrorResponse(
        int status,
        String error,
        String message,
        long timestamp
) {
}
