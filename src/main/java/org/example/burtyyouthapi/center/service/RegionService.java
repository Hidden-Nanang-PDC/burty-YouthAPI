package org.example.burtyyouthapi.center.service;

import org.example.burtyyouthapi.center.dto.RegionDto;
import org.example.burtyyouthapi.center.repository.YouthCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 지역 목록 조회 비즈니스 로직
 */
@Service
public class RegionService {

    private final YouthCenterRepository repo;

    @Autowired
    public RegionService(YouthCenterRepository repo) {
        this.repo = repo;
    }

    /**
     * 모든 시도 코드·명칭 목록 반환
     */
    public List<RegionDto> getAllProvinces() {
        return repo.findDistinctProvinces();
    }

    /**
     * 특정 시도에 속한 시군구 코드·명칭 목록 반환
     * @param ctpvCd 시도 코드
     */
    public List<RegionDto> getDistrictsByProvince(String ctpvCd) {
        return repo.findDistinctDistrictsByProvince(ctpvCd);
    }
}
