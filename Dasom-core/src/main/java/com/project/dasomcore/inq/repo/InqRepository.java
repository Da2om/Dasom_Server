package com.project.dasomcore.inq.repo;

import com.project.dasomcore.inq.domain.entity.Inq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InqRepository extends JpaRepository<Inq, Long>, QuerydslInqRepository {
}
