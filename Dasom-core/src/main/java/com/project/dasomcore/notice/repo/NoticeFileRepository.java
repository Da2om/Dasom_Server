package com.project.dasomcore.notice.repo;

import com.project.dasomcore.notice.domain.entity.Notice;
import com.project.dasomcore.notice.domain.entity.NoticeFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeFileRepository extends JpaRepository<NoticeFile, Long> {
    void deleteByNotice(Notice notice);
}
