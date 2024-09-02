package com.project.dasomcore.child.repo;

import com.project.dasomcore.child.domain.entity.Child;
import org.springframework.data.repository.CrudRepository;

public interface ChildRepository extends CrudRepository<Child,Long>, QuerydslChildRepository {
}
