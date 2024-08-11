package com.project.dasomcore.inq.application.service;

import com.project.dasomapi.common.request.PageRequest;
import com.project.dasomapi.inq.handler.req.InqInfoRes;
import com.project.dasomcore.inq.application.response.InqRes;
import com.project.dasomcore.inq.repo.InqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InqSearchService {

    private final InqRepository inqRepository;

    public List<InqRes> inqList(PageRequest req){
        return inqRepository.inqList(req);
    }

    public InqInfoRes inqInfo(Long inqId){
        return inqRepository.inqInfo(inqId);
    }

}
