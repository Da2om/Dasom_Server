package com.project.dasomcore.notice.application.service;

import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public interface S3Util {
    String uploadFile(String uuid, InputStream inputStream);
}
