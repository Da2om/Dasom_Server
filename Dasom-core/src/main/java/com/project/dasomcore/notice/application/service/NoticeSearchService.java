package com.project.dasomcore.notice.application.service;

import com.project.dasomapi.common.request.PageRequest;
import com.project.dasomcore.notice.application.response.NoticeInfoRes;
import com.project.dasomcore.notice.application.response.NoticeRes;
import com.project.dasomcore.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeSearchService {

    private final NoticeRepository noticeRepository;

    public NoticeInfoRes noticeInfo(Long noticeId){
        return noticeRepository.noticeInfo(noticeId);
    }

    public List<NoticeRes> noticeList(PageRequest request){
        return noticeRepository.noticeList(request);
    }

}
