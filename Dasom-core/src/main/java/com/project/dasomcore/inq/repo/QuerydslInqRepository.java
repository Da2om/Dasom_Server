package com.project.dasomcore.inq.repo;

import com.project.dasomcore.inq.application.response.InqInfoRes;
import com.project.dasomcore.inq.application.response.InqRes;

import java.util.List;

public interface QuerydslInqRepository {
    List<InqRes> inqList(int page,int size);
    InqInfoRes inqInfo(Long inqId);
}
