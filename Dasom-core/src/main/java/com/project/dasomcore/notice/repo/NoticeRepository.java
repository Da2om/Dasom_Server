package com.project.dasomcore.notice.repo;

import com.project.dasomcore.notice.domain.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice,Long> , QuerydslNoticeRepository {

}
