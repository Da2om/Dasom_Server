package com.project.dasomcore.notice.repo;

import com.project.dasomcore.notice.domain.entity.Notice;
import com.project.dasomcore.notice.repo.querydsl.CustomNotificationRepo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice,Long> , CustomNotificationRepo {

}
