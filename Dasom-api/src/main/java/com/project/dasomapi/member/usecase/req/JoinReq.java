package com.project.dasomapi.member.usecase.req;

import com.project.dasomcore.member.domain.consts.MemberClass;
import com.project.dasomcore.member.domain.consts.MemberRole;
import com.project.dasomcore.member.domain.consts.MemberState;
import com.project.dasomcore.member.domain.entity.Member;
import jakarta.annotation.Nullable;

public record JoinReq(
        String email,
        String username,
        String pw,
        String name,
        String pushToken,
        String authCode,
        Integer classInCharge,
        int role
) {
    public Member toEntity(String encodePw){
        return Member.builder()
                .email(email)
                .pw(encodePw)
                .name(name)
                .state(MemberState.ACTIVATE)
                .classInCharge(MemberClass.of(classInCharge))
                .role(MemberRole.of(role))
                .isOnChattingAlarm(Boolean.TRUE)
                .isOnNoticeAlarm(Boolean.TRUE)
                .build();
    }
}