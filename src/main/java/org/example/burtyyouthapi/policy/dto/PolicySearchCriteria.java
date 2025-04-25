package org.example.burtyyouthapi.policy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * 정책 검색용 파라미터 DTO
 * – 각 필드를 다중 선택 가능하도록 List<String> 타입으로 변경
 */
@Data
@NoArgsConstructor
public class PolicySearchCriteria {
    private List<String> plcyMajorCd;    // 전공조건코드(comCd), 다중 선택 가능
    private List<String> jobCd;          // 취업상태코드(comCd), 다중 선택 가능
    private List<String> sBizCd;         // 특수분야코드(comCd), 다중 선택 가능
    private List<String> plcyPvsnMthdCd; // 정책제공방법코드(comCd), 다중 선택 가능
    private List<String> earnCndSeCd;    // 소득조건구분코드(comCd), 다중 선택 가능
    private List<String> plcyAprvSttsCd; // 정책승인상태코드(comCd), 다중 선택 가능
    private List<String> schoolCd;       // 자격학력코드(comCd), 다중 선택 가능
    private List<String> pvsnInstGroupCd;// 제공기관그룹코드(comCd), 다중 선택 가능
    private List<String> mrgSttsCd;      // 결혼상태코드(comCd), 다중 선택 가능

    private String zipCd;                // 거주지역코드 (단일)

    private int page = 0;                // 0부터 시작하는 페이지 번호
    private int size = 10;               // 한 페이지당 결과 수
}
