package com.project.dasomcore.notice.application.service;

import com.project.dasomcore.child.domain.entity.Child;
import com.project.dasomcore.member.domain.entity.Member;
import com.project.dasomcore.notice.application.response.MyClassNoticeListRes;
import com.project.dasomcore.notice.application.response.MyNoticeListRes;
import com.project.dasomcore.notice.application.response.NoticeInfoRes;
import com.project.dasomcore.notice.domain.entity.Notice;
import com.project.dasomcore.notice.domain.exception.NoticeNotFoundException;
import com.project.dasomcore.notice.repo.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public Notice saveNotice(Notice notice){
        return noticeRepository.save(notice);
    }

    public NoticeInfoRes noticeInfo(Long noticeId){
        return noticeRepository.noticeInfo(noticeId);
    }

    public List<MyNoticeListRes> getMyNotices(Long page, Long size,Child child){
        return noticeRepository.getMyNotices(page,size,child);
    }

    public List<MyClassNoticeListRes> getMyClassNotices(Long page, Long size, Member member){
        return noticeRepository.getMyClassNotices(page,size,member.getClassInCharge());
    }

    public Notice getById(Long id) {
        return noticeRepository.findById(id)
                .orElseThrow(NoticeNotFoundException::new);
    }
}
