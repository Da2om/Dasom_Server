package com.project.dasomapi.child.usecase.req;

import com.project.dasomapi.common.util.DateUtil;
import com.project.dasomcore.child.domain.consts.BloodType;
import com.project.dasomcore.child.domain.consts.Gender;
import com.project.dasomcore.child.domain.entity.Child;

import java.time.LocalDate;

public record ChildModifyReq(
        Long id,
        String name,
        String cls,
        String gender,
        LocalDate birthDt,
        String bloodType,
        Boolean isDisease
) {
    public Child toEntity(){
        return Child.builder()
                .childName(name)
                .birthDt(birthDt)
                .cls(cls)
                .gender(Gender.of(gender))
                .bloodType(BloodType.of(bloodType))
                .age(DateUtil.DtToYear(birthDt))
                .isDisease(isDisease)
                .build();
    }
}
