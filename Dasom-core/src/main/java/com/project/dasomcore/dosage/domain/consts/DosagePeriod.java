package com.project.dasomcore.dosage.domain.consts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DosagePeriod {
    BEFORE_MEAL("식전"),
    AFTER_MEAL("식후"),
    NONE("투약안함");

    private final String value;

//    public static String of(DosagePeriod dosagePeriod) {
//        return dosagePeriod.getValue();
//    }

}
