package com.project.dasomcore.notice.repo;

import com.project.dasomcore.notice.domain.entity.File;
import com.project.dasomcore.notice.repo.querydsl.CustomFileRepo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> , CustomFileRepo {
}
