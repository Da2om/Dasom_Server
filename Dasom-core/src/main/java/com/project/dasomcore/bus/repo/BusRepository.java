package com.project.dasomcore.bus.repo;

import com.project.dasomcore.bus.domain.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BusRepository extends JpaRepository<Bus,Long> ,QuerydslBusRepository{

}
