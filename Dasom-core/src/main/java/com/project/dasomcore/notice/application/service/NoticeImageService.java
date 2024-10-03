package com.project.dasomcore.notice.application.service;

import com.project.dasomcore.notice.domain.entity.Notice;
import com.project.dasomcore.notice.domain.entity.NoticeImage;
import com.project.dasomcore.notice.repo.NoticeImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

@Service
@RequiredArgsConstructor
@Transactional
public class NoticeImageService {

    private final NoticeImageRepository imageRepository;

    public void saveImage(NoticeImage image) {
        imageRepository.save(image);
    }

    public void deleteByNotice(Notice notice) {
        imageRepository.deleteByNotice(notice);
    }
}
