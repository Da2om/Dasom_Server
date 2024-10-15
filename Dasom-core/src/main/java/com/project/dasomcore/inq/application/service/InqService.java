package com.project.dasomcore.inq.application.service;

import com.project.dasomcore.inq.application.response.InqInfoRes;
import com.project.dasomcore.inq.application.response.InqRes;
import com.project.dasomcore.inq.domain.entity.Inq;
import com.project.dasomcore.inq.repo.InqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InqService {

    private final InqRepository inqRepository;

    public List<InqRes> inqList(int page, int size){
        return inqRepository.inqList(page,size);
    }

    public InqInfoRes inqInfo(Long inqId){
        return inqRepository.inqInfo(inqId);
    }

    public void saveInq(Inq inq) {
        inqRepository.save(inq);
    }

}
