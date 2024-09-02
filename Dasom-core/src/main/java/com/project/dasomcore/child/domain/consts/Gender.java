package com.project.dasomcore.child.domain.consts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@Getter
@RequiredArgsConstructor
public enum Gender {
    BOY("남성"),
    GIRL("여성");

    private final String gender;

    public static Gender of(String gender) {
        return Arrays.stream(values())
                .filter(value -> Objects.equals(value.gender, gender))
                .findAny()
                .orElse(null);
    }
}
