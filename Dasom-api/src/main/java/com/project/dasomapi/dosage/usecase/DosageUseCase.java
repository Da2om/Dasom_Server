package com.project.dasomapi.dosage.usecase;

import com.project.dasomapi.common.Response;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomapi.common.dto.PageRequest;
import com.project.dasomapi.dosage.usecase.req.RequestDosageReq;
import com.project.dasomcore.child.application.ChildService;
import com.project.dasomcore.child.domain.entity.Child;
import com.project.dasomcore.dosage.application.DosageService;
import com.project.dasomcore.dosage.application.response.DosageRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class DosageUseCase {

    private final DosageService dosageService;
    private final ChildService childService;

    public Response requestDosage(RequestDosageReq req, Long childId) {
        Child child = childService.getById(childId);
        dosageService.save(req.toEntity(child));
        return Response.created("투약 의뢰 저장 성공");
    }

    public ResponseData<List<DosageRes>> dosageList(PageRequest request, String year, String month, String date) {
        List<DosageRes> res = dosageService.getDosages(request.page(),request.size(),year,month,date);
        return ResponseData.ok("투약 의뢰 조회 성공",res);
    }

    public ResponseData<List<DosageRes>> getMyDosages(PageRequest request,Long childId) {
        List<DosageRes> res = dosageService.getMyDosages(request.page(),request.size(),childId);
        return ResponseData.ok("내 원아 투약의뢰 조회 성공",res);
    }

    public Response remove(Long id) {
        dosageService.deleteById(id);
        return Response.ok("투약의뢰 삭제 성공");
    }
}
