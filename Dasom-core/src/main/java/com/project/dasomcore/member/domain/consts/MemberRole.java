package com.project.dasomcore.member.domain.consts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum MemberRole {
    PARENT("ROLE_PARENT",1),
    TEACHER("ROLE_TEACHER",2);

    private final String role;
    private final int number;

    public static MemberRole of(int number) {
        return Arrays.stream(values())
                .filter(value -> value.number == number)
                .findAny()
                .orElse(null);
    }
}