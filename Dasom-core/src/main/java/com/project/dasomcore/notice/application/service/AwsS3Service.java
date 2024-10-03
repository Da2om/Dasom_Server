package com.project.dasomcore.notice.application.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
public interface AwsS3Service {
    String upload(MultipartFile multipartFile, String dirName);
}
