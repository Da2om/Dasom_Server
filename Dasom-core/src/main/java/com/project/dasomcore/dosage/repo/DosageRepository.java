package com.project.dasomcore.dosage.repo;

import com.project.dasomcore.dosage.domain.entity.Dosage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DosageRepository extends JpaRepository<Dosage, Long>,QuerydslDosageRepository {
}
