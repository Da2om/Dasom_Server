package com.project.dasomcore.notice.application.response;

import java.time.LocalDate;

public record NoticeInfoRes(String title,LocalDate writtenDt,String content,String name) {}
