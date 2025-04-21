package org.example.burtyyouthapi.policy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 정책 검색 결과 리스트용 DTO (A안)
 * - 목록 화면에서 보여줄 정보 + 검색 조건 코드값을 함께 포함
 * - 상세 조회를 위한 정책 ID(plcyNo) 필드 추가
 */
@Data
@AllArgsConstructor
public class PolicyDto {
    /** 정책번호 (상세조회 ID) */
    private String plcyNo;

    /** 정책 중분류명 */
    private String mclsfNm;

    /** 정책명 */
    private String plcyNm;

    /** 정책 설명 (간략 텍스트) */
    private String plcyExplnCn;

    /** 정책 대분류명 */
    private String lclsfNm;

    /** 주관기관 코드명 */
    private String sprvsnInstCdNm;

    /** 지원대상 최소 연령 */
    private String sprtTrgtMinAge;

    /** 지원대상 최대 연령 */
    private String sprtTrgtMaxAge;

    /** 신청기간 (예: "20250101~20251231" 또는 "상시") */
    private String aplyYmd;

    // 검색 필터용 코드값
    /** 전공조건코드 (comCd) */
    private String plcyMajorCd;
    /** 취업상태코드 (comCd) */
    private String jobCd;
    /** 학력조건코드 (comCd) */
    private String schoolCd;
    /** 특수분야코드 (comCd) */
    private String sBizCd;
    /** 정책제공방법코드 (comCd) */
    private String plcyPvsnMthdCd;
    /** 정책승인상태코드 (comCd) */
    private String plcyAprvSttsCd;
    /** 소득조건구분코드 (comCd) */
    private String earnCndSeCd;
    /** 결혼상태코드 (comCd) */
    private String mrgSttsCd;
    /** 제공기관그룹코드 (comCd) */
    private String pvsnInstGroupCd;
}
