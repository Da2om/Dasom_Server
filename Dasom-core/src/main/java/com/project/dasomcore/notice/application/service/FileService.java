package com.project.dasomcore.notice.application.service;

import com.project.dasomcore.notice.domain.entity.File;
import com.project.dasomcore.notice.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;

    public void saveFile(File file) {
        fileRepository.save(file);
    }

}
