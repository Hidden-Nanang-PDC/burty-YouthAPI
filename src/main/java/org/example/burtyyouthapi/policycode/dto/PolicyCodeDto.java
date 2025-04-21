package org.example.burtyyouthapi.policycode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 프론트엔드에 반환할 정책 코드(필터) DTO
 * - code: comCd
 * - name: cdNm
 */
@Data
@AllArgsConstructor
public class PolicyCodeDto {
    /** 코드값 (comCd) */
    private String code;

    /** 코드명 (cdNm) */
    private String name;
}
