package org.example.burtyyouthapi.policy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 정책 검색용 파라미터 DTO
 * - 기존 필터에 더해 거주지역 코드(zipCd) 추가
 */
@Data
@NoArgsConstructor
public class PolicySearchCriteria {
    private String plcyMajorCd;   // 전공조건코드
    private String jobCd;         // 취업상태코드
    private String sBizCd;        // 특수분야코드
    private String plcyPvsnMthdCd; // 정책제공방법코드
    private String earnCndSeCd;   // 소득조건구분코드
    private String plcyAprvSttsCd;// 정책승인상태코드
    private String schoolCd;      // 자격학력코드
    private String pvsnInstGroupCd;// 제공기관그룹코드
    private String mrgSttsCd;     // 결혼상태코드

    /** 새로 추가된 필터: 거주지역코드(zipCd) */
    private String zipCd;

    private int page = 0;             // 0부터 시작하는 페이지 번호
    private int size = 10;            // 한 페이지당 결과 수
}
