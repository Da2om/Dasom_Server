package com.project.dasomcore.notice.repository;

import com.project.dasomcore.notice.domain.Notice;
import com.project.dasomcore.notice.repository.querydsl.NoticeRepoCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice,Long> , NoticeRepoCustom {

}
