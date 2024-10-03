package com.project.dasomapi.notice.usecase.req;

import org.springframework.web.multipart.MultipartFile;

public record UploadNoticeFileReq(MultipartFile file) {
}
