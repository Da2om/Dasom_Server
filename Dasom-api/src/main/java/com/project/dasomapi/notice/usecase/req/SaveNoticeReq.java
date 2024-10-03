package com.project.dasomapi.notice.usecase.req;

import com.project.dasomcore.child.domain.entity.Child;
import com.project.dasomcore.member.domain.entity.Member;
import com.project.dasomcore.notice.domain.consts.ShareScope;
import com.project.dasomcore.notice.domain.entity.Notice;

import java.time.LocalDateTime;
import java.util.List;

public record SaveNoticeReq(
        String title,
        String content,
        ShareScope shareScope,
        Long childIdToShare,
        List<String> imageList,
        List<String> fileList) {
    public Notice toEntity(Member member, Child child) {
        return Notice.builder()
                .title(this.title)
                .content(this.content)
                .writtenDt(LocalDateTime.now())
                .member(member)
                .shareScope(this.shareScope)
                .sharingChild(child)
                .build();
    }
}
