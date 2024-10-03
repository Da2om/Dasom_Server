package com.project.dasomcore.notice.repo;

import com.project.dasomcore.child.domain.entity.Child;
import com.project.dasomcore.member.domain.consts.MemberClass;
import com.project.dasomcore.notice.application.response.MyClassNoticeListRes;
import com.project.dasomcore.notice.application.response.MyNoticeListRes;
import com.project.dasomcore.notice.application.response.NoticeInfoRes;

import java.util.List;

public interface QuerydslNoticeRepository {

    NoticeInfoRes noticeInfo(Long id);

    List<MyNoticeListRes> getMyNotices(Long page, Long size, Child child);

    List<MyClassNoticeListRes> getMyClassNotices(Long page, Long size, MemberClass myClass);

}
