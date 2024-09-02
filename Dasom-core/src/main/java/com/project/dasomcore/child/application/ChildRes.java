package com.project.dasomcore.child.application;

import com.project.dasomcore.child.domain.consts.BloodType;
import com.project.dasomcore.child.domain.consts.Gender;

import java.time.LocalDate;

public record ChildRes(
        Long childId,
        String childName,
        Integer age,
        String cls,
        Gender gender,
        LocalDate birthDt,
        BloodType bloodType,
        Boolean isDisease
) {
}