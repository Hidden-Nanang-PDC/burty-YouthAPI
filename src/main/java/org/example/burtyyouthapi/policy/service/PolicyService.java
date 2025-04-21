package org.example.burtyyouthapi.policy.service;

import org.example.burtyyouthapi.model.entity.Policy;
import org.example.burtyyouthapi.policy.dto.PolicyDetailDto;
import org.example.burtyyouthapi.policy.dto.PolicyDto;
import org.example.burtyyouthapi.policy.dto.PolicySearchCriteria;
import org.example.burtyyouthapi.policy.repository.PolicyRepository;
import org.example.burtyyouthapi.policy.spec.PolicySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * Policy 조회 및 검색 비즈니스 로직 처리 서비스
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
     */
    public Page<PolicyDto> searchPolicies(PolicySearchCriteria criteria) {
        Pageable pageable = PageRequest.of(
                criteria.getPage(),
                criteria.getSize(),
                Sort.by(Sort.Direction.DESC, "frstRegDt")
        );
        Specification<Policy> spec = PolicySpecification.withFilters(criteria);
        Page<Policy> page = repository.findAll(spec, pageable);

        // Entity → DTO 변환 시 plcyNo를 첫 번째 인자로 포함
        return page.map(this::toDto);
    }

    private PolicyDto toDto(Policy policy) {
        return new PolicyDto(
                // plcyNo 추가
                policy.getPlcyNo(),
                policy.getMclsfNm(),
                policy.getPlcyNm(),
                policy.getPlcyExplnCn(),
                policy.getLclsfNm(),
                policy.getSprvsnInstCdNm(),
                policy.getSprtTrgtMinAge(),
                policy.getSprtTrgtMaxAge(),
                policy.getAplyYmd(),
                policy.getPlcyMajorCd(),
                policy.getJobCd(),
                policy.getSchoolCd(),
                policy.getSBizCd(),
                policy.getPlcyPvsnMthdCd(),
                policy.getPlcyAprvSttsCd(),
                policy.getEarnCndSeCd(),
                policy.getMrgSttsCd(),
                policy.getPvsnInstGroupCd()
        );
    }

    /**
     * 단일 정책 ID로 정책 상세 정보를 조회합니다.
     */
    public PolicyDetailDto getPolicyDetail(String plcyNo) {
        Policy policy = repository.findById(plcyNo)
                .orElseThrow(() -> new NoSuchElementException("정책을 찾을 수 없습니다: " + plcyNo));
        return toDetailDto(policy);
    }

    private PolicyDetailDto toDetailDto(Policy policy) {
        return new PolicyDetailDto(
                policy.getPlcyNm(),
                policy.getPlcyKywdNm(),
                policy.getPlcyExplnCn(),
                policy.getLclsfNm(),
                policy.getMclsfNm(),
                policy.getPlcySprtCn(),
                policy.getSprvsnInstCdNm(),
                policy.getOperInstCdNm(),
                policy.getPlcyAplyMthdCn(),
                policy.getSrngMthdCn(),
                policy.getAplyUrlAddr(),
                policy.getSbmsnDcmntCn(),
                policy.getSprtTrgtMinAge(),
                policy.getSprtTrgtMaxAge(),
                policy.getAddAplyQlfcCndCn(),
                policy.getAplyYmd(),
                policy.getFrstRegDt(),
                policy.getLastMdfcnDt()
        );
    }
}
