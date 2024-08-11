package com.project.dasomcore.inq.repo;

import com.project.dasomcore.inq.domain.entity.Inq;
import com.project.dasomcore.inq.repo.querydsl.CustomInqRepo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InqRepository extends JpaRepository<Inq, Long>, CustomInqRepo {
}
