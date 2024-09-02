package com.project.dasomapi.inq.handler.req;

import com.project.dasomcore.inq.domain.entity.Inq;

public record SaveInqReq(String title, String content) {
    public Inq toEntity(String email){
        return Inq.builder()
                .title(this.title)
                .content(this.content)
                .fkMemberId(email).build();
    }
}
