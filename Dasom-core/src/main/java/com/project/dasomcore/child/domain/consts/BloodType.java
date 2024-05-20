package com.project.dasomcore.child.domain.consts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@Getter
@RequiredArgsConstructor
public enum BloodType {
    A("A"),
    B("B"),
    AB("AB"),
    O("O");

    private final String bloodType;

    public static BloodType of(String bloodType) {
        return Arrays.stream(values())
                .filter(value -> Objects.equals(value.bloodType, bloodType))
                .findAny()
                .orElse(null);
    }
}
