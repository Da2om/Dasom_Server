package com.project.dasomcore.notice.application.response;

import java.time.LocalDateTime;
import java.util.List;

public record NoticeInfoRes(
        String title,
        String content,
        LocalDateTime writtenDt,
        String writerName,
        List<String> imageUrl,
        List<String> fileUrl
) {

}
