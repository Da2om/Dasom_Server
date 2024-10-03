package com.project.dasomcore.notice.repo;

import com.project.dasomcore.notice.domain.entity.Notice;
import com.project.dasomcore.notice.domain.entity.NoticeImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeImageRepository extends JpaRepository<NoticeImage, Long> {
    void deleteByNotice(Notice notice);
}
