package com.project.dasomcore.notice.application.response;

import java.time.LocalDateTime;

public record MyNoticeListRes(
        Long noticeId,
        String title,
        LocalDateTime writtenDt,
        String writerName) {
}
