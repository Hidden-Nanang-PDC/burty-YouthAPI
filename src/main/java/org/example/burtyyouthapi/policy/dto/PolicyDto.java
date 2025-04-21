package org.example.burtyyouthapi.policy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 프론트엔드에 전달할 정책 조회 결과 DTO
 * - 화면에 필요한 최소한의 필드를 포함
 */
@Data
@AllArgsConstructor
public class PolicyDto {
    private String plcyNo;            // 정책번호
    private String plcyNm;            // 정책명
    private String plcyExplnCn;       // 정책설명내용
    private String plcyMajorCd;       // 전공조건코드
    private String jobCd;             // 취업상태코드
    private String schoolCd;          // 학력요건코드
    private String sBizCd;            // 특수분야코드
    private String earnCndSeCd;       // 소득조건구분코드
    private String plcyAprvSttsCd;    // 정책승인상태코드
    private String pvsnInstGroupCd;   // 제공기관그룹코드
    private String mrgSttsCd;         // 결혼상태코드
}
