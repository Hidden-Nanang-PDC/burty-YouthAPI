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
     * 이제 zipCd(거주지역코드) 필터링과 DTO에 zipCd 반환을 지원합니다.
     */
    public Page<PolicyDto> searchPolicies(PolicySearchCriteria criteria) {
        Pageable pageable = PageRequest.of(
                criteria.getPage(),
                criteria.getSize(),
                Sort.by(Sort.Direction.DESC, "frstRegDt")
        );

        Specification<Policy> spec = PolicySpecification.byCriteria(criteria);
        Page<Policy> page = repository.findAll(spec, pageable);

        return page.map(this::toDto);
    }

    /**
     * 단일 정책 ID로 정책 상세 정보를 조회합니다.
     */
    public PolicyDetailDto getPolicyDetail(String plcyNo) {
        Policy policy = repository.findById(plcyNo)
                .orElseThrow(() -> new NoSuchElementException("정책을 찾을 수 없습니다: " + plcyNo));
        return toDetailDto(policy);
    }

    /**
     * Entity → 목록용 DTO 변환
     */
    private PolicyDto toDto(Policy policy) {
        return new PolicyDto(
                policy.getPlcyNo(),               // 정책번호
                policy.getMclsfNm(),              // 정책중분류명
                policy.getPlcyNm(),               // 정책명
                policy.getPlcyExplnCn(),          // 정책설명
                policy.getLclsfNm(),              // 정책대분류명
                policy.getSprvsnInstCdNm(),       // 주관기관코드명
                policy.getSprtTrgtMinAge(),       // 지원대상최소연령
                policy.getSprtTrgtMaxAge(),       // 지원대상최대연령
                policy.getAplyYmd(),              // 신청기간
                policy.getPlcyMajorCd(),          // 전공조건코드
                policy.getJobCd(),                // 취업상태코드
                policy.getSchoolCd(),             // 자격학력코드
                policy.getSBizCd(),               // 특수분야코드
                policy.getPlcyPvsnMthdCd(),       // 정책제공방법코드
                policy.getPlcyAprvSttsCd(),       // 정책승인상태코드
                policy.getEarnCndSeCd(),          // 소득조건구분코드
                policy.getMrgSttsCd(),            // 결혼상태코드
                policy.getPvsnInstGroupCd(),      // 제공기관그룹코드
                policy.getZipCd()                 // 거주지역코드 (새로 추가)
        );
    }

    /**
     * Entity → 상세용 DTO 변환
     */
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
