package org.example.burtyyouthapi.policy.service;

import org.example.burtyyouthapi.model.entity.Policy;
import org.example.burtyyouthapi.policy.dto.PolicyDto;
import org.example.burtyyouthapi.policy.dto.PolicySearchCriteria;
import org.example.burtyyouthapi.policy.repository.PolicyRepository;
import org.example.burtyyouthapi.policy.spec.PolicySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.domain.Specification;

/**
 * Policy 조회 및 검색 비즈니스 로직 처리 서비스
 * - Specification 기반 동적 필터링 지원
 * - 페이지네이션 및 정렬 기능 포함
 */
@Service
public class PolicyService {

    private final PolicyRepository repository;

    @Autowired
    public PolicyService(PolicyRepository repository) {
        this.repository = repository;
    }

    /**
     * 검색 조건에 따라 페이징된 정책 목록을 반환합니다.
     *
     * @param criteria 검색 조건 및 페이징 정보
     * @return 페이징 처리된 PolicyDto 리스트
     */
    public Page<PolicyDto> searchPolicies(PolicySearchCriteria criteria) {
        Pageable pageable = PageRequest.of(
                criteria.getPage(),
                criteria.getSize(),
                Sort.by(Sort.Direction.DESC, "frstRegDt")  // 등록일 내림차순 정렬
        );

        Specification<Policy> spec = PolicySpecification.withFilters(criteria);
        Page<Policy> page = repository.findAll(spec, pageable);

        return page.map(this::toDto);
    }

    /** Policy 엔티티를 PolicyDto로 변환 */
    private PolicyDto toDto(Policy policy) {
        return new PolicyDto(
                policy.getPlcyNo(),
                policy.getPlcyNm(),
                policy.getPlcyExplnCn(),
                policy.getPlcyMajorCd(),
                policy.getJobCd(),
                policy.getSchoolCd(),
                policy.getSBizCd(),
                policy.getEarnCndSeCd(),
                policy.getPlcyAprvSttsCd(),
                policy.getPvsnInstGroupCd(),
                policy.getMrgSttsCd()
        );
    }
}
