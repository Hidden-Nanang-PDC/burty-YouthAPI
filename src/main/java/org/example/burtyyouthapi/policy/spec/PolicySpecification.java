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

            // zipCd 필터는 하나만!
            if (c.getZipCd() != null && !c.getZipCd().isEmpty()) {
                predicates.add(cb.equal(root.get("zipCd"), c.getZipCd()));
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
            Predicate pFull = cb.equal(root.get("zipCd"), fullCode);
            Predicate pProvince = cb.equal(root.get("zipCd"), provinceOnly);
            return cb.or(pFull, pProvince);
        };
    }
}
