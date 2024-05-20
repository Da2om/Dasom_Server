package com.project.dasomapi.auth.usecase.req;

public record LoginReq(
        String email,
        String pw
) {
}
