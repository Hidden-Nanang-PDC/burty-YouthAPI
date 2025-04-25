package org.example.burtyyouthapi.policy.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.burtyyouthapi.policy.dto.PolicyDetailDto;
import org.example.burtyyouthapi.policy.dto.PolicyDto;
import org.example.burtyyouthapi.policy.dto.PolicySearchCriteria;
import org.example.burtyyouthapi.policy.service.PolicyService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

/**
 * 정책 검색 및 조회 API 컨트롤러
 * - /api/policies/search, /api/policies/{plcyNo} 엔드포인트 제공
 */
@Tag(name = "Policy", description = "정책 검색 및 상세 조회 API")
@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    private final PolicyService service;

    @Autowired
    public PolicyController(PolicyService service) {
        this.service = service;
    }

    /**
     * GET /api/policies/search
     * 검색 필터에 맞춰 페이징된 정책 목록을 반환합니다.
     */
    @Operation(
            summary = "정책 목록 검색",
            description = "전공, 취업상태 등 다양한 필터 조건으로 정책 목록을 페이징 조회합니다.<br/>"
            + "ex) Policy-code에서 [전공조건코드]로 공학계열인 0011005값을 얻어와서 plcyMajorCd에 넣어주고 조회하면 공학계열에 관련된 정책이 조회됨.<br/>"
            + "👉 <a href='https://github.com/Hidden-Nanang-PDC/burty-YouthAPI/blob/main/PolicyCodeAPI_PolicyAPI_Matching.md' target='_blank'>더 자세한 카테고리 코드와 정책 목록 파라미터 매칭 정보 </a>"
    )
    @GetMapping("/search")
    public Page<PolicyDto> searchPolicies(@ParameterObject PolicySearchCriteria criteria) {
        return service.searchPolicies(criteria);
    }

    @Operation(summary = "지역 기반 정책 목록", description = "시도(ctpvCd)와 시군구(sggCd)를 입력받아 해당 지역(및 상위 시도) 정책을 페이징 조회합니다.")
    @GetMapping("/region")
    public Page<PolicyDetailDto> searchByRegion(
            @RequestParam String ctpvCd,
            @RequestParam String sggCd,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size
    ) {
        return service.searchByRegion(ctpvCd, sggCd, page, size);
    }

    /**
     * GET /api/policies/{plcyNo}
     * 단일 정책 번호로 상세 정보를 조회하여 반환합니다.
     *
     * @param plcyNo 정책 번호
     * @return PolicyDetailDto
     */
    @Operation(
            summary = "정책 상세 조회",
            description = "지정된 정책 번호에 해당하는 상세 정보를 반환합니다."
    )
    @GetMapping("/{plcyNo}")
    public PolicyDetailDto getPolicyDetail(@PathVariable String plcyNo) {
        try {
            return service.getPolicyDetail(plcyNo);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e
            );
        }
    }
}
