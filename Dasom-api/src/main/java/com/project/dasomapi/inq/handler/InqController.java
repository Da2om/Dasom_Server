package com.project.dasomapi.inq.handler;

import com.project.dasomapi.common.Response;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomapi.common.dto.PageRequest;
import com.project.dasomcore.inq.application.response.InqInfoRes;
import com.project.dasomapi.inq.handler.req.SaveInqReq;
import com.project.dasomapi.inq.usecase.InqUseCase;
import com.project.dasomcore.inq.application.response.InqRes;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inq")
public class InqController {

    private final InqUseCase useCase;

    /**
     * 문의 작성
     * */
    @PostMapping
    public Response saveInq(
            @RequestBody SaveInqReq req
    ){
        return useCase.saveInq(req);
    }

    /**
     * 문의 리스트
     * */
    @GetMapping("/list")
    @Transactional(readOnly = true)
    public ResponseData<List<InqRes>> inqList(
            @ModelAttribute PageRequest req
    ){
        return useCase.inqList(req);
    }

    /**
     * 문의 상세
     * */
    @GetMapping
    public ResponseData<InqInfoRes> noticeInfo(
            @RequestParam Long inqId
    ){
        return useCase.inqInfo(inqId);
    }

}
