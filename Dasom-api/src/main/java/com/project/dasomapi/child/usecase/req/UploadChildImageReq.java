package com.project.dasomapi.child.usecase.req;

import org.springframework.web.multipart.MultipartFile;

public record UploadChildImageReq(MultipartFile file) {
}
