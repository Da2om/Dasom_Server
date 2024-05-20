package com.project.dasomapi.member.usecase.req;

import com.project.dasomcore.member.domain.consts.MemberRole;
import com.project.dasomcore.member.domain.consts.MemberState;
import com.project.dasomcore.member.domain.entity.Member;

public record JoinReq(
        String email,
        String pw,
        String name,
        String tel,
        String pushToken,
        String authCode,
        int role
) {
    public Member toEntity(String encodePw){
        return Member.builder()
                .email(email)
                .pw(encodePw)
                .name(name)
                .tel(tel)
                .state(MemberState.ACTIVATE)
                .role(MemberRole.of(role))
                .isOnChattingAlarm(Boolean.TRUE)
                .isOnNoticeAlarm(Boolean.TRUE)
                .build();
    }
}