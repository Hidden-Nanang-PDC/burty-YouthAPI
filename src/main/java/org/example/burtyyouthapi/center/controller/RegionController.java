package org.example.burtyyouthapi.center.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.burtyyouthapi.center.dto.RegionDto;
import org.example.burtyyouthapi.center.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 센터 지역(시도/시군구) 코드 조회 API
 * - /api/centers/regions/ctpv  : 시도 목록
 * - /api/centers/regions/sgg   : 시도별 시군구 목록
 */
@RestController
@RequestMapping("/api/centers/regions")
public class RegionController {

    private final RegionService service;

    @Autowired
    public RegionController(RegionService service) {
        this.service = service;
    }

    /**
     * GET /api/centers/regions/ctpv
     * DB에 저장된 센터 데이터를 바탕으로 중복 없는 시도 코드·명칭 목록 반환
     */
    @Operation(
            summary = "시도 코드 조회",
            description = "그냥 조회하면 시도 코드 조회"
    )
    @GetMapping("/ctpv")
    public List<RegionDto> getProvinces() {
        return service.getAllProvinces();
    }

    /**
     * GET /api/centers/regions/sgg?ctpvCd={ctpvCd}
     * 지정된 시도 코드에 해당하는 중복 없는 시군구 목록 반환
     * @param ctpvCd 시도 코드
     */
    @Operation(
            summary = "시군구 코드 조회",
            description = "시도 코드를 넣고 조회하면 해당 시도의 시군구 목록 조회"
    )
    @GetMapping("/sgg")
    public List<RegionDto> getDistricts(@RequestParam String ctpvCd) {
        return service.getDistrictsByProvince(ctpvCd);
    }
}
