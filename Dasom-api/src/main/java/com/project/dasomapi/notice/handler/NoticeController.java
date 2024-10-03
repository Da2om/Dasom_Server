package com.project.dasomapi.notice.handler;

import com.project.dasomapi.common.Response;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomapi.common.dto.PageRequest;
import com.project.dasomapi.notice.usecase.req.SaveNoticeReq;
import com.project.dasomapi.notice.usecase.NoticeUseCase;
import com.project.dasomapi.notice.usecase.req.UploadNoticeFileReq;
import com.project.dasomapi.notice.usecase.req.UploadNoticeImageReq;
import com.project.dasomcore.notice.application.response.MyClassNoticeListRes;
import com.project.dasomcore.notice.application.response.MyNoticeListRes;
import com.project.dasomcore.notice.application.response.NoticeInfoRes;
import com.project.dasomcore.notice.application.response.UploadNoticeFileRes;
import com.project.dasomcore.notice.application.response.UploadNoticeImageRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notice")
@Tag(name = "알림장", description = "알림장 API")
public class NoticeController {

    private final NoticeUseCase noticeUseCase;

    /**
     * 알림장 상세
     * */
    @GetMapping("/{id}")
    @Operation(summary = "알림장 상세 조회", description = " 알림장 정보 상세 조회(authorized)")
    public ResponseData<NoticeInfoRes> noticeInfo(
            @PathVariable(name="id") Long id
    ){
        return noticeUseCase.noticeInfo(id);
    }

    /**
     * 부모님의 알림장 리스트 조회
     * */
    @GetMapping("/my")
    @Transactional(readOnly = true)
    @Operation(summary = "알림장 리스트 조회", description = "학부모앱으로 알림장 리스트 조회할때(parent)")
    public ResponseData<List<MyNoticeListRes>> myNoticeList(
            @ModelAttribute PageRequest request,
            @RequestParam Long id
    ){
        return noticeUseCase.myNoticeList(request,id);
    }

    /**
     * 자기 반 알림장 리스트 (선생님)
     * */
    @GetMapping("/my-class")
    @Transactional(readOnly = true)
    @Operation(summary = "알림장 리스트 조회", description = "선생님앱으로 알림장 리스트 조회할때[우리 반 기준 조회](teacher)")
    public ResponseData<List<MyClassNoticeListRes>> myClassNoticeList(
            @ModelAttribute PageRequest request
    ){
        return noticeUseCase.myClassNoticeList(request);
    }

    /**
     * 알림장 작성
     * */
    @PostMapping
    @Operation(summary = "알림장 작성", description = "알림장 정보 저장(teacher)")
    public Response saveNotice(
            @RequestBody SaveNoticeReq req
    ){
        return noticeUseCase.saveNotice(req);
    }

    /**
     * 알림장 수정
     * */
    @PutMapping("/{id}")
    @Operation(summary = "알림장 수정", description = "알림장 정보 수정(teacher)")
    public Response updateNotice(
            @PathVariable(name="id") Long id,
            @RequestBody SaveNoticeReq req
    ){
        return noticeUseCase.updateNotice(req,id);
    }

    @PostMapping("/image")
    @Operation(summary = "이미지 등록", description = "이미지 s3에 등록하고 url반환 (teacher)")
    public ResponseData<UploadNoticeImageRes> uploadImage(@RequestBody UploadNoticeImageReq req) {
        return noticeUseCase.uploadImage(req);
    }

    @PostMapping("/file")
    @Operation(summary = "파일 등록", description = "파일 s3에 등록하고 url반환 (teacher)")
    public ResponseData<UploadNoticeFileRes> uploadImage(@RequestBody UploadNoticeFileReq req) {
        return noticeUseCase.uploadFile(req);
    }

}
