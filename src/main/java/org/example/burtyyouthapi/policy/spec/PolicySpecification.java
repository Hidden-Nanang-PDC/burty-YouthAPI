package org.example.burtyyouthapi.policy.spec;

import jakarta.persistence.criteria.Predicate;
import org.example.burtyyouthapi.model.entity.Policy;
import org.example.burtyyouthapi.policy.dto.PolicySearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

/**
 * Policy 검색에 사용될 동적 WHERE 절을 Specification 형태로 구현
 * - PolicySearchCriteria의 각 필드를 확인하여 Predicate를 생성
 */
public class PolicySpecification {

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

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
