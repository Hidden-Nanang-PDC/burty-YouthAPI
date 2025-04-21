package org.example.burtyyouthapi.policy.controller;

import org.example.burtyyouthapi.policy.dto.PolicyDto;
import org.example.burtyyouthapi.policy.dto.PolicySearchCriteria;
import org.example.burtyyouthapi.policy.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * 정책 검색 API 컨트롤러
 * - /api/policies/search 엔드포인트 제공
 */
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
     *
     * @param criteria 필터 조건과 페이징 정보가 담긴 DTO
     * @return 페이징된 PolicyDto 목록
     */
    @GetMapping("/search")
    public Page<PolicyDto> searchPolicies(PolicySearchCriteria criteria) {
        return service.searchPolicies(criteria);
    }
}
