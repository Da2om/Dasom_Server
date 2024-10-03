package com.project.dasomapi.dosage.handler;

import com.project.dasomapi.common.Response;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomapi.common.dto.PageRequest;
import com.project.dasomapi.dosage.usecase.DosageUseCase;
import com.project.dasomapi.dosage.usecase.req.RequestDosageReq;
import com.project.dasomcore.dosage.application.response.DosageRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dosage")
@RequiredArgsConstructor
@Tag(name = "투약", description = "투약 API")
public class DosageController {

    private final DosageUseCase dosageUseCase;

    @PostMapping("/{id}")
    @Operation(summary = "투약 요청", description = "투약 요청을 저장 (parent)")
    public Response requestDosage(
            @PathVariable(name = "id") Long id,
            @RequestBody RequestDosageReq req
    ){
        return dosageUseCase.requestDosage(req,id);
    }

    @GetMapping("/list")
    @Operation(summary = "투약 리스트 반환", description = "날짜 기준 투약 리스트 반환 (teacher)")
    public ResponseData<List<DosageRes>> dosageList(
            @ModelAttribute PageRequest pageRequest,
            @RequestParam String year,
            @RequestParam String month,
            @RequestParam String date
    ){
        return dosageUseCase.dosageList(pageRequest,year,month,date);
    }

}
