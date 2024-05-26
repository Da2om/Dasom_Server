package com.project.dasomapi.notice.handler;

import com.project.dasomapi.notice.request.SaveNoticeReq;
import com.project.dasomapi.notice.usecase.NoticeUseCase;
import com.project.dasomcore.notice.application.response.NoticeInfoRes;
import com.project.dasomcore.notice.application.service.NoticeSearchService;
import com.project.dasomcore.notice.application.response.NoticeRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeSearchService searchService;
    private final NoticeUseCase useCase;

    /**
     * 알림장 상세
     * */
    @GetMapping
    public NoticeInfoRes noticeInfo(
            @RequestParam Long noticeId
    ){
        return searchService.noticeInfo(noticeId);
    }

    /**
     * 알림장 작성
     * */
    @PostMapping
    public void saveNotice(
            @RequestBody SaveNoticeReq req
    ){
        useCase.saveNotice(req);
    }

    /**
     * 알림장 리스트
     * */
    @GetMapping("/list")
    public List<NoticeRes> noticeList(){
        return searchService.noticeList();
    }

}
