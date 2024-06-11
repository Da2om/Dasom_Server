package com.project.dasomapi.notice.usecase;

import com.project.dasomapi.common.Response;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomapi.notice.request.SaveNoticeReq;
import com.project.dasomcore.member.application.MemberSessionHolder;
import com.project.dasomcore.notice.application.response.NoticeInfoRes;
import com.project.dasomcore.notice.application.response.NoticeRes;
import com.project.dasomcore.notice.application.service.FileService;
import com.project.dasomcore.notice.application.service.NoticeRegisterService;
import com.project.dasomcore.notice.application.service.NoticeSearchService;
import com.project.dasomcore.notice.application.service.S3Util;
import com.project.dasomcore.notice.domain.File;
import com.project.dasomcore.notice.domain.Notice;
import com.project.dasomcore.notice.domain.exception.FileUploadException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class NoticeUseCase {

    private final NoticeRegisterService noticeRegisterService;
    private final NoticeSearchService noticeSearchService;
    private final MemberSessionHolder memberSessionHolder;
    private final FileService fileService;

    public ResponseData<NoticeInfoRes> noticeInfo(Long noticeId) {
        return ResponseData.ok("알림장 조회 성공", noticeSearchService.noticeInfo(noticeId));
    }

    public List<NoticeRes> noticeList() {
        return noticeSearchService.noticeList();
    }

    public Response saveNotice(SaveNoticeReq req){
        noticeRegisterService.saveNotice(req.toEntity(memberSessionHolder.current()));
        return Response.ok("알림장 저장 성공");
    }

    public Response fileUpload(MultipartFile file,Long noticeId) throws IOException{
        String url = S3Util.uploadFile(generateType4UUID(),file.getInputStream());

        String fileName = file.getOriginalFilename();
        fileService.saveFile(File.builder()
                .url(url)
                .name(fileName)
                .size(file.getSize())
                .extension(getExtension(fileName))
                .memberId(memberSessionHolder.current())
                .noticeId(noticeId).build());
        return Response.ok("파일 업로드 성공");
    }

    /**
     * UUID v4를 생성합니다.
     * @return
     */
    private static String generateType4UUID() {
        // 버전 4 UUID 생성하기
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    /**
     * 파일 확장자를 추출합니다.
     * @return
     */
    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}
