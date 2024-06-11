package com.project.dasomapi.notice.request;

import com.project.dasomcore.notice.domain.Notice;

public record SaveNoticeReq(String title, String content) {
    public Notice toEntity(String userId) {
        return Notice.builder()
                .title(title())
                .content(content())
                .fkMemberId(userId)
                .build();
    }
}
