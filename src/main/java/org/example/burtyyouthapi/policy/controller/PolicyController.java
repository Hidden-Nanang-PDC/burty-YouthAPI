package org.example.burtyyouthapi.policy.controller;

import org.example.burtyyouthapi.policy.dto.PolicyDetailDto;
import org.example.burtyyouthapi.policy.dto.PolicyDto;
import org.example.burtyyouthapi.policy.dto.PolicySearchCriteria;
import org.example.burtyyouthapi.policy.service.PolicyService;
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
    @GetMapping("/search")
    public Page<PolicyDto> searchPolicies(PolicySearchCriteria criteria) {
        return service.searchPolicies(criteria);
    }

    /**
     * GET /api/policies/{plcyNo}
     * 단일 정책 번호로 상세 정보를 조회하여 반환합니다.
     *
     * @param plcyNo 정책 번호
     * @return PolicyDetailDto
     */
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
