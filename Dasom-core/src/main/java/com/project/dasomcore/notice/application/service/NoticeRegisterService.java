package com.project.dasomcore.notice.application.service;

import com.project.dasomcore.notice.domain.entity.Notice;
import com.project.dasomcore.notice.repo.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeRegisterService {

    private final NoticeRepository noticeRepository;

    public void saveNotice(Notice notice){
        noticeRepository.save(notice);
    }

}
