package com.project.dasomcore.notice.application.service;

import com.project.dasomcore.notice.domain.entity.Notice;
import com.project.dasomcore.notice.domain.entity.NoticeFile;
import com.project.dasomcore.notice.domain.entity.NoticeImage;
import com.project.dasomcore.notice.repo.NoticeFileRepository;
import com.project.dasomcore.notice.repo.NoticeImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class NoticeFileService {

    private final NoticeFileRepository fileRepository;

    public void saveFile(NoticeFile file) {
        fileRepository.save(file);
    }

    public void deleteByNotice(Notice notice) {
        fileRepository.deleteByNotice(notice);
    }
}
