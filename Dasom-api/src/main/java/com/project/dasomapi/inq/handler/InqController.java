package com.project.dasomapi.inq.handler;

import com.project.dasomapi.common.Response;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomapi.common.dto.PageRequest;
import com.project.dasomcore.inq.application.response.InqInfoRes;
import com.project.dasomapi.inq.handler.req.SaveInqReq;
import com.project.dasomapi.inq.usecase.InqUseCase;
import com.project.dasomcore.inq.application.response.InqRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "문의", description = "문의 API")
public class InqController {

    private final InqUseCase useCase;

    /**
     * 문의 작성
     * */
    @PostMapping
    @Operation(summary = "문의 저장", description = "문의 사항을 받아서 저장 (authorized)")
    public Response saveInq(
            @RequestBody SaveInqReq req
    ){
        return useCase.saveInq(req);
    }

//    /**
//     * 문의 리스트
//     * */
//    @GetMapping("/list")
//    @Transactional(readOnly = true)
//    @Operation(summary = "문의 리스트 조회", description = "문의 리스트를 조회함. (authorized)")
//    public ResponseData<List<InqRes>> inqList(
//            @ModelAttribute PageRequest req
//    ){
//        return useCase.inqList(req);
//    }

//    /**
//     * 문의 상세
//     * */
//    @GetMapping
//    @Operation(summary = "문의 상세 조회", description = "문의글 상세 정보를 조회함. (authorized)")
//    public ResponseData<InqInfoRes> noticeInfo(
//            @RequestParam Long inqId
//    ){
//        return useCase.inqInfo(inqId);
//    }

}
