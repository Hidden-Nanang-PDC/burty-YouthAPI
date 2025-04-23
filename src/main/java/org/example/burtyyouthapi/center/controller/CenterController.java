package org.example.burtyyouthapi.center.controller;

import org.example.burtyyouthapi.center.dto.CenterDto;
import org.example.burtyyouthapi.center.dto.CenterSearchCriteria;
import org.example.burtyyouthapi.center.service.CenterService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 센터 검색 API 컨트롤러
 * - /api/centers/search 엔드포인트 제공
 */
@RestController
@RequestMapping("/api/centers")
@Tag(name = "Centers", description = "센터 검색 및 조회 API")
public class CenterController {

    private final CenterService service;

    @Autowired
    public CenterController(CenterService service) {
        this.service = service;
    }

    /**
     * GET /api/centers/search
     * 시도(stdgCtpvCd)와 시군구(stdgSggCd) 필터에 맞춰 페이징된 센터 목록을 반환합니다.
     */
    @Operation(
            summary = "센터 목록 검색",
            description = "시도 및 시군구 조건으로 센터 목록을 페이징 조회합니다."
    )
    @GetMapping("/search")
    public Page<CenterDto> searchCenters(@ParameterObject CenterSearchCriteria criteria) {
        return service.searchCenters(criteria);
    }
}
