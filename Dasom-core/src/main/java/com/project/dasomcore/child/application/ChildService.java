package com.project.dasomcore.child.application;

import com.project.dasomcore.child.domain.entity.Child;
import com.project.dasomcore.child.repo.ChildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ChildService {
    private final ChildRepository childRepository;

    public void save(Child child){
        childRepository.save(child);
    }
}
