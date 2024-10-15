package com.project.dasomapi.inq.handler.req;

import com.project.dasomcore.inq.domain.entity.Inq;
import com.project.dasomcore.member.domain.entity.Member;

public record SaveInqReq(String title, String content) {
    public Inq toEntity(Member member) {
        return Inq.builder()
                .title(this.title)
                .content(this.content)
                .member(member).build();
    }
}
