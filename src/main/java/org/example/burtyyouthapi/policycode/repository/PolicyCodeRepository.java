package org.example.burtyyouthapi.policycode.repository;

import org.example.burtyyouthapi.policycode.entity.PolicyCode;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * PolicyCode 엔티티 CRUD 및 그룹별 조회 지원
 */
public interface PolicyCodeRepository extends JpaRepository<PolicyCode, String> {

    /**
     * 코드그룹명(cdGroupNm)으로 필터 옵션 목록 조회
     * @param cdGroupNm 그룹명 (예: "전공조건코드")
     * @return 해당 그룹에 속한 PolicyCode 리스트
     */
    List<PolicyCode> findByCdGroupNm(String cdGroupNm);
}
