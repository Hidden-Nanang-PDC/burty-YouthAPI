package org.example.burtyyouthapi.policycode.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * DB 테이블 `youth_policy_code` 매핑 엔티티
 * - 정책 필터 옵션(코드)을 저장하는 테이블
 */
@Entity
@Table(name = "youth_policy_code")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyCode {

    /** 공통코드(comCd)를 PK로 사용 */
    @Id
    @Column(name = "com_cd", length = 50)
    private String comCd;

    /** 코드그룹코드 */
    @Column(name = "cd_group_cd", length = 50)
    private String cdGroupCd;

    /** 코드그룹명 (예: 전공조건코드, 취업상태코드) */
    @Column(name = "cd_group_nm")
    private String cdGroupNm;

    /** 코드명 (예: 인문계열, 재직자 등) */
    @Column(name = "cd_nm")
    private String cdNm;

    /** 코드설명 */
    @Column(name = "cd_expln", columnDefinition = "TEXT")
    private String cdExpln;

    /** 최초등록일시 */
    @Column(name = "frst_reg_dt")
    private String frstRegDt;

    /** 최종수정일시 */
    @Column(name = "last_mdfcn_dt")
    private String lastMdfcnDt;
}
