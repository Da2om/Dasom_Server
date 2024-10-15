package com.project.dasomcore.bus.application.res;

import com.project.dasomcore.member.domain.consts.MemberClass;

import java.time.LocalDateTime;

public record BusRes(
        Long busId,
        LocalDateTime boardTime,
        boolean isBoard,
        String childName,
        MemberClass childClass) {
}
