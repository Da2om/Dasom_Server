package com.project.dasomcore.dosage.application;

import com.project.dasomcore.dosage.application.response.DosageRes;
import com.project.dasomcore.dosage.domain.entity.Dosage;
import com.project.dasomcore.dosage.repo.DosageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DosageService {

    private final DosageRepository dosageRepository;

    public void save(Dosage dosage) {
        dosageRepository.save(dosage);
    }

    public List<DosageRes> getDosages(Long page, Long size, String year, String month, String date) {
        return dosageRepository.getDosages(page,size,year,month,date);
    }
}
