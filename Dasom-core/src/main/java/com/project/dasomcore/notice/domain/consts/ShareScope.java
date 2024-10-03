package com.project.dasomcore.notice.domain.consts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@Getter
@RequiredArgsConstructor
public enum ShareScope {
    CLASS("반"),
    PERSONAL("개인");

    private final String scope;

    public static ShareScope of(String scope) {
        return Arrays.stream(values())
                .filter(value -> Objects.equals(value.scope, scope))
                .findAny()
                .orElse(null);
    }
}
