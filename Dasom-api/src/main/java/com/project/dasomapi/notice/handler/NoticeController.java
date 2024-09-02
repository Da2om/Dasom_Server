package com.project.dasomapi.notice.handler;

import com.project.dasomapi.common.Response;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomapi.common.request.PageRequest;
import com.project.dasomapi.notice.request.SaveNoticeReq;
import com.project.dasomapi.notice.usecase.NoticeUseCase;
import com.project.dasomcore.notice.application.response.NoticeInfoRes;
import com.project.dasomcore.notice.application.response.NoticeRes;
import com.project.dasomcore.notice.domain.exception.FileUploadException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeUseCase useCase;

    /**
     * 알림장 상세
     * */
    @GetMapping
    public ResponseData<NoticeInfoRes> noticeInfo(
            @RequestParam Long noticeId
    ){
        return useCase.noticeInfo(noticeId);
    }

    /**
     * 알림장 리스트
     * */
    @GetMapping("/list")
    @Transactional(readOnly = true)
    public ResponseData<List<NoticeRes>> noticeList(
            @ModelAttribute PageRequest request
    ){
        return useCase.noticeList(request);
    }

    /**
     * 알림장 작성
     * */
    @PostMapping
    public Response saveNotice(
            @RequestBody SaveNoticeReq req
    ){
        return useCase.saveNotice(req);
    }

    @PostMapping("/fileupload")
    public Response fileUpload(
            @RequestParam("file") MultipartFile file,
            @RequestParam Long id
    ) {
        try {
            return useCase.fileUpload(file, id);
        } catch (IOException e) {
            throw new FileUploadException();
        }
    }

}
