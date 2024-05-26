package com.project.dasomapi.notice.usecase;

import com.project.dasomapi.notice.request.SaveNoticeReq;
import com.project.dasomcore.notice.application.service.NoticeRegisterService;
import com.project.dasomcore.notice.domain.Notice;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class NoticeUseCase {

    private final NoticeRegisterService noticeRegisterService;

    public NoticeUseCase(NoticeRegisterService noticeRegisterService){
        this.noticeRegisterService = noticeRegisterService;
    }

    public void saveNotice(SaveNoticeReq req){
        noticeRegisterService.saveNotice(Notice.builder()
                .title(req.title())
                .content(req.content())
                .writtenDt(LocalDate.now())
//                .fkMemberId()
                .build());
    }
}
