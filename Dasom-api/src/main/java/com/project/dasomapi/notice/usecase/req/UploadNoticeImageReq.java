package com.project.dasomapi.notice.usecase.req;

import org.springframework.web.multipart.MultipartFile;

public record UploadNoticeImageReq(MultipartFile file) {
}
