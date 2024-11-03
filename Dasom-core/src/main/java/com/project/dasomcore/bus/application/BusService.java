package com.project.dasomcore.bus.application;

import com.project.dasomcore.bus.application.res.BusRes;
import com.project.dasomcore.bus.application.res.MyBusRes;
import com.project.dasomcore.bus.domain.entity.Bus;
import com.project.dasomcore.bus.domain.exception.BusNotFoundException;
import com.project.dasomcore.bus.repo.BusRepository;
import com.project.dasomcore.member.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class BusService {

    private final BusRepository busRepository;

    public void save(Bus bus) {
        busRepository.save(bus);
    }

    public List<MyBusRes> getMyBus(Member member) {
        return busRepository.getMyBus(member);
    }

    public void deleteById(Long id) {
        busRepository.deleteById(id);
    }

    public List<BusRes> getBusList() {
        return busRepository.getBusList();
    }

    public List<BusRes> getModifiedBusList() {
        return busRepository.getModifiedBusList();
    }

    public Bus getById(Long id) {
        return busRepository.findById(id)
                .orElseThrow(BusNotFoundException::new);
    }
}
