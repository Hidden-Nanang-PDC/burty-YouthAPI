package org.example.burtyyouthapi.policy.spec;

import jakarta.persistence.criteria.Predicate;
import org.example.burtyyouthapi.model.entity.Policy;
import org.example.burtyyouthapi.policy.dto.PolicySearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

/**
 * Policy 검색용 동적 Specification 클래스
 */
public class PolicySpecification {

    /**
     * 기존 필터 조건을 모두 적용하는 Specification
     */
    public static Specification<Policy> withFilters(PolicySearchCriteria criteria) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (criteria.getPlcyMajorCd() != null) {
                predicates.add(cb.equal(root.get("plcyMajorCd"), criteria.getPlcyMajorCd()));
            }
            if (criteria.getJobCd() != null) {
                predicates.add(cb.equal(root.get("jobCd"), criteria.getJobCd()));
            }
            if (criteria.getSBizCd() != null) {
                predicates.add(cb.equal(root.get("sBizCd"), criteria.getSBizCd()));
            }
            if (criteria.getPlcyPvsnMthdCd() != null) {
                predicates.add(cb.equal(root.get("plcyPvsnMthdCd"), criteria.getPlcyPvsnMthdCd()));
            }
            if (criteria.getEarnCndSeCd() != null) {
                predicates.add(cb.equal(root.get("earnCndSeCd"), criteria.getEarnCndSeCd()));
            }
            if (criteria.getPlcyAprvSttsCd() != null) {
                predicates.add(cb.equal(root.get("plcyAprvSttsCd"), criteria.getPlcyAprvSttsCd()));
            }
            if (criteria.getSchoolCd() != null) {
                predicates.add(cb.equal(root.get("schoolCd"), criteria.getSchoolCd()));
            }
            if (criteria.getPvsnInstGroupCd() != null) {
                predicates.add(cb.equal(root.get("pvsnInstGroupCd"), criteria.getPvsnInstGroupCd()));
            }
            if (criteria.getMrgSttsCd() != null) {
                predicates.add(cb.equal(root.get("mrgSttsCd"), criteria.getMrgSttsCd()));
            }
            if (criteria.getZipCd() != null) {
                predicates.add(cb.equal(root.get("zipCd"), criteria.getZipCd()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    /**
     * 지역 기반 필터만 적용하는 Specification
     * - 시도코드(province)와 시군구코드(district)를 합쳐서 fullCode
     * - provinceOnly = province + "000"
     * - true if zipCd == fullCode OR zipCd == provinceOnly
     */
    public static Specification<Policy> byRegion(String province, String district) {
        return (root, query, cb) -> {
            String fullCode = province + district;
            String provinceOnly = province + "000";
            Predicate pFull   = cb.equal(root.get("zipCd"), fullCode);
            Predicate pProvince = cb.equal(root.get("zipCd"), provinceOnly);
            return cb.or(pFull, pProvince);
        };
    }
}
