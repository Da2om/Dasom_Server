package com.project.dasomcore.inq.repo.querydsl;

import com.project.dasomapi.common.request.PageRequest;
import com.project.dasomapi.inq.handler.req.InqInfoRes;
import com.project.dasomcore.inq.application.response.InqRes;

import java.util.List;

public interface CustomInqRepo {
    List<InqRes> inqList(PageRequest req);
    InqInfoRes inqInfo(Long inqId);
}
