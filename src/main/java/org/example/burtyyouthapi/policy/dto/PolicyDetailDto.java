package org.example.burtyyouthapi.policy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 정책 상세보기용 DTO
 * - 상세 페이지에서 보여줄 모든 정보 필드를 담습니다.
 * - 여기에 지역코드(zipCd)를 추가했습니다.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyDetailDto {
    /** 정책명 */
    private String plcyNm;

    /** 정책 키워드명 (쉼표 구분 키워드) */
    private String plcyKywdNm;

    /** 정책 설명 전체 내용 (HTML 포함 가능) */
    private String plcyExplnCn;

    /** 정책 대분류명 */
    private String lclsfNm;

    /** 정책 중분류명 */
    private String mclsfNm;

    /** 정책 지원 내용 상세 */
    private String plcySprtCn;

    /** 주관기관 코드명 */
    private String sprvsnInstCdNm;

    /** 운영기관 코드명 */
    private String operInstCdNm;

    /** 정책 신청 방법 내용 */
    private String plcyAplyMthdCn;

    /** 심사 방법 내용 */
    private String srngMthdCn;

    /** 신청 URL 주소 */
    private String aplyUrlAddr;

    /** 제출 서류 내용 */
    private String sbmsnDcmntCn;

    /** 지원대상 최소 연령 */
    private String sprtTrgtMinAge;

    /** 지원대상 최대 연령 */
    private String sprtTrgtMaxAge;

    /** 추가 신청 자격 조건 내용 */
    private String addAplyQlfcCndCn;

    /** 신청기간 (예: 20250101~20251231 또는 "상시") */
    private String aplyYmd;

    /** 최초 등록 일시 (YYYY-MM-DD HH:mm:ss) */
    private String frstRegDt;

    /** 최종 수정 일시 (YYYY-MM-DD HH:mm:ss) */
    private String lastMdfcnDt;

    /** 정책 거주지역 코드 (zipCd) */
    private String zipCd;
}
