package com.project.dasomcore.notice.repository;

import com.project.dasomcore.notice.domain.File;
import com.project.dasomcore.notice.repository.querydsl.CustomFileRepo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> , CustomFileRepo {
}
