package com.project.dasomcore.schedule.repo;

import com.project.dasomcore.schedule.domain.entity.Schedule;
import com.project.dasomcore.schedule.repo.querydsl.CustomScheduleRepo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>, CustomScheduleRepo {
}
