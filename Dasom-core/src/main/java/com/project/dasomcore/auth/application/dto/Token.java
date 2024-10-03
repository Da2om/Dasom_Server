package com.project.dasomcore.auth.application.dto;

public record Token(
        String accessToken,
        String refreshToken
) {
}
