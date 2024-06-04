package com.project.dasomapi.notice.usecase;

import com.project.dasomapi.notice.request.SaveNoticeReq;
import com.project.dasomcore.notice.application.response.NoticeInfoRes;
import com.project.dasomcore.notice.application.response.NoticeRes;
import com.project.dasomcore.notice.application.service.NoticeRegisterService;
import com.project.dasomcore.notice.application.service.NoticeSearchService;
import com.project.dasomcore.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class NoticeUseCase {

    private final NoticeRegisterService noticeRegisterService;
    private final NoticeSearchService noticeSearchService;

    public NoticeInfoRes noticeInfo(Long noticeId) {
        return noticeSearchService.noticeInfo(noticeId);
    }

    public List<NoticeRes> noticeList() {
        return noticeSearchService.noticeList();
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
