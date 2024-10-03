package com.project.dasomapi.notice.usecase;

import com.project.dasomapi.common.Response;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomapi.common.dto.PageRequest;
import com.project.dasomapi.notice.usecase.req.SaveNoticeReq;
import com.project.dasomapi.notice.usecase.req.UploadNoticeFileReq;
import com.project.dasomapi.notice.usecase.req.UploadNoticeImageReq;
import com.project.dasomcore.child.application.ChildService;
import com.project.dasomcore.child.domain.entity.Child;
import com.project.dasomcore.member.application.MemberSessionHolder;
import com.project.dasomcore.member.domain.entity.Member;
import com.project.dasomcore.notice.application.response.MyClassNoticeListRes;
import com.project.dasomcore.notice.application.response.MyNoticeListRes;
import com.project.dasomcore.notice.application.response.NoticeInfoRes;
import com.project.dasomcore.notice.application.response.UploadNoticeFileRes;
import com.project.dasomcore.notice.application.response.UploadNoticeImageRes;
import com.project.dasomcore.notice.application.service.AwsS3Service;
import com.project.dasomcore.notice.application.service.NoticeFileService;
import com.project.dasomcore.notice.application.service.NoticeImageService;
import com.project.dasomcore.notice.application.service.NoticeService;
import com.project.dasomcore.notice.domain.consts.ShareScope;
import com.project.dasomcore.notice.domain.entity.Notice;
import com.project.dasomcore.notice.domain.entity.NoticeFile;
import com.project.dasomcore.notice.domain.entity.NoticeImage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class NoticeUseCase {

    private final NoticeService noticeService;
    private final NoticeImageService imageService;
    private final NoticeFileService fileService;

    private final AwsS3Service awsS3Service;

    private final MemberSessionHolder memberSessionHolder;
    private final ChildService childService;

    public ResponseData<NoticeInfoRes> noticeInfo(Long noticeId) {
        NoticeInfoRes res = noticeService.noticeInfo(noticeId);
        return ResponseData.ok("알림장 조회 성공", res);
    }

    public ResponseData<List<MyNoticeListRes>> myNoticeList(PageRequest request,Long childId) {
        request.validate();
        Child child = childService.getById(childId);
        List<MyNoticeListRes> res = noticeService.getMyNotices(request.page(), request.size(),child);
        return ResponseData.ok("알림장 리스트 조회 성공",res);
    }

    public ResponseData<List<MyClassNoticeListRes>> myClassNoticeList(PageRequest request) {
        request.validate();
        Member member = memberSessionHolder.current();
        List<MyClassNoticeListRes> res = noticeService.getMyClassNotices(request.page(), request.size(),member);
        return ResponseData.ok("알림장 리스트 조회 성공",res);
    }

    public Response saveNotice(SaveNoticeReq req){
        // 알림장 저장
        Member writer = memberSessionHolder.current();
        Child sharingChild = null;
        if(req.shareScope() == ShareScope.PERSONAL) {
            sharingChild = childService.getById(req.childIdToShare());
        }

        Notice notice = noticeService.saveNotice(req.toEntity(writer,sharingChild));

        // 이미지 저장
        for (String imageUrl : req.imageList()) {
            imageService.saveImage(NoticeImage.builder()
                    .url(imageUrl)
                    .notice(notice).build());
        }

        // 파일 저장
        for (String fileUrl : req.fileList()) {
            fileService.saveFile(NoticeFile.builder()
                    .url(fileUrl)
                    .notice(notice).build());
        }

        return Response.created("알림장 저장 성공");
    }

    public ResponseData<UploadNoticeImageRes> uploadImage(UploadNoticeImageReq req) {
        String url = awsS3Service.upload(req.file(),"notice_image");
        UploadNoticeImageRes res = UploadNoticeImageRes.of(url);
        return ResponseData.created("알림장 사진 업로드 성공",res);
    }

    public ResponseData<UploadNoticeFileRes> uploadFile(UploadNoticeFileReq req) {
        String url = awsS3Service.upload(req.file(),"notice_file");
        UploadNoticeFileRes res = UploadNoticeFileRes.of(url);
        return ResponseData.created("알림장 파일 업로드 성공",res);
    }

    public Response updateNotice(SaveNoticeReq req,Long id) {
        // 알림장 조회
        Notice notice = noticeService.getById(id);
        Child sharingChild = null;
        if(req.shareScope() == ShareScope.PERSONAL) {
            sharingChild = childService.getById(req.childIdToShare());
        }
        // 수정
        notice.update(req.title(),req.content(),req.shareScope(),sharingChild);

        imageService.deleteByNotice(notice);
        // 이미지 수정
        for (String imageUrl : req.imageList()) {
            imageService.saveImage(NoticeImage.builder()
                    .url(imageUrl)
                    .notice(notice).build());
        }

        fileService.deleteByNotice(notice);
        // 파일 수정
        for (String fileUrl : req.fileList()) {
            fileService.saveFile(NoticeFile.builder()
                    .url(fileUrl)
                    .notice(notice).build());
        }

        return Response.created("알림장 수정 성공");
    }
}
