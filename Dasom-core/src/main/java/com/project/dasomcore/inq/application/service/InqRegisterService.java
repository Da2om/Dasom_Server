package com.project.dasomcore.inq.application.service;

import com.project.dasomcore.inq.domain.entity.Inq;
import com.project.dasomcore.inq.repo.InqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InqRegisterService {

    private final InqRepository inqRepository;

    public void saveInq(Inq inq) {
        inqRepository.save(inq);
    }

}
