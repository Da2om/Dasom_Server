package com.project.dasomcore.notice.repository.querydsl;

import com.project.dasomapi.common.request.PageRequest;
import com.project.dasomcore.notice.application.response.NoticeInfoRes;
import com.project.dasomcore.notice.application.response.NoticeRes;

import java.util.List;

public interface CustomNotificationRepo {

    NoticeInfoRes noticeInfo(Long id);

    List<NoticeRes> noticeList(PageRequest request);

}
