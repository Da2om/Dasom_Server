package com.project.dasominfra.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dasomcore.common.exception.ErrorResponseEntity;
import com.project.dasomcore.common.exception.ExceptionCode;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public final class ErrorResponseSender {

    private final ObjectMapper objectMapper;

    public void send(HttpServletResponse response, ExceptionCode code) {
        ErrorResponseEntity entity = getErrorResponseEntity(code);
        try {
            response.setStatus(entity.getStatus());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(entity));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ErrorResponseEntity getErrorResponseEntity(ExceptionCode code) {
        return ErrorResponseEntity.builder()
                .status(code.getHttpStatus().value())
                .code(code.getExceptionName())
                .message(code.getMessage())
                .build();
    }

}