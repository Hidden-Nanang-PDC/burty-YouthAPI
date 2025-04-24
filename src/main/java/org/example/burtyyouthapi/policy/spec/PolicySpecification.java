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

    public static Specification<Policy> byCriteria(PolicySearchCriteria c) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (c.getPlcyMajorCd() != null && !c.getPlcyMajorCd().isEmpty()) {
                predicates.add(cb.equal(root.get("plcyMajorCd"), c.getPlcyMajorCd()));
            }
            if (c.getJobCd() != null && !c.getJobCd().isEmpty()) {
                predicates.add(cb.equal(root.get("jobCd"), c.getJobCd()));
            }
            if (c.getSBizCd() != null && !c.getSBizCd().isEmpty()) {
                predicates.add(cb.equal(root.get("sBizCd"), c.getSBizCd()));
            }
            if (c.getPlcyPvsnMthdCd() != null && !c.getPlcyPvsnMthdCd().isEmpty()) {
                predicates.add(cb.equal(root.get("plcyPvsnMthdCd"), c.getPlcyPvsnMthdCd()));
            }
            if (c.getEarnCndSeCd() != null && !c.getEarnCndSeCd().isEmpty()) {
                predicates.add(cb.equal(root.get("earnCndSeCd"), c.getEarnCndSeCd()));
            }
            if (c.getPlcyAprvSttsCd() != null && !c.getPlcyAprvSttsCd().isEmpty()) {
                predicates.add(cb.equal(root.get("plcyAprvSttsCd"), c.getPlcyAprvSttsCd()));
            }
            if (c.getSchoolCd() != null && !c.getSchoolCd().isEmpty()) {
                predicates.add(cb.equal(root.get("schoolCd"), c.getSchoolCd()));
            }
            if (c.getPvsnInstGroupCd() != null && !c.getPvsnInstGroupCd().isEmpty()) {
                predicates.add(cb.equal(root.get("pvsnInstGroupCd"), c.getPvsnInstGroupCd()));
            }
            if (c.getMrgSttsCd() != null && !c.getMrgSttsCd().isEmpty()) {
                predicates.add(cb.equal(root.get("mrgSttsCd"), c.getMrgSttsCd()));
            }
            // 새로 추가된 지역 필터: zipCd
            if (c.getZipCd() != null && !c.getZipCd().isEmpty()) {
                predicates.add(cb.equal(root.get("zipCd"), c.getZipCd()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}