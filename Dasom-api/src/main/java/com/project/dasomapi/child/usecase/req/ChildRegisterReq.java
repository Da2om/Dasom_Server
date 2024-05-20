package com.project.dasomapi.child.usecase.req;

import com.project.dasomapi.common.util.DateUtil;
import com.project.dasomcore.child.domain.consts.BloodType;
import com.project.dasomcore.child.domain.consts.Gender;
import com.project.dasomcore.child.domain.entity.Child;
import com.project.dasomcore.member.domain.entity.Member;

import java.time.LocalDate;

public record ChildRegisterReq(
        String name,
        String cls,
        String gender,
        LocalDate birthDt,
        String bloodType
) {
    public Child toEntity(Member member){
        return Child.builder()
                .childName(name)
                .birthDt(birthDt)
                .cls(cls)
                .gender(Gender.of(gender))
                .bloodType(BloodType.of(bloodType))
                .age(DateUtil.DtToYear(birthDt))
                .isDisease(Boolean.FALSE)
                .member(member)
                .build();
    }
}