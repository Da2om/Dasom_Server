package com.project.dasomcore.member.domain.consts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum MemberClass {
    SUNFLOWER("해바라기반",1),
    ROSE("장미반",2),
    CHERRY_BLOSSOM("벚꽃반",3);

    private final String role;
    private final int number;

    public static MemberClass of(int number) {
        return Arrays.stream(values())
                .filter(value -> value.number == number)
                .findAny()
                .orElse(null);
    }
}
