package org.example.burtyyouthapi.policy.dto;

import lombok.Data;

/**
 * 클라이언트로부터 전달받을 검색 필터 조건을 정의한 DTO
 * 모든 필드는 선택(optional)이며, 지정된 경우에만 쿼리에 반영됩니다.
 * - page, size: 페이징 처리를 위한 기본값(0, 10)
 */
@Data
public class PolicySearchCriteria {
    private String plcyMajorCd;       // 전공조건코드(comCd)
    private String jobCd;             // 취업상태코드(comCd)
    private String sBizCd;            // 특수분야코드(comCd)
    private String plcyPvsnMthdCd;    // 정책제공방법코드(comCd)
    private String earnCndSeCd;       // 소득조건구분코드(comCd)
    private String plcyAprvSttsCd;    // 정책승인상태코드(comCd)
    private String schoolCd;          // 자격학력코드(comCd)
    private String pvsnInstGroupCd;   // 제공기관그룹코드(comCd)
    private String mrgSttsCd;         // 결혼상태코드(comCd)

    /** 새로 추가된 필터: 거주지역코드(zipCd) */
    private String zipCd;

    private int page = 0;             // 0부터 시작하는 페이지 번호
    private int size = 10;            // 한 페이지당 결과 수
}
