package org.example.burtyyouthapi.center.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 센터 검색용 파라미터 DTO
 * - 시도/시군구 필터 및 페이징 정보 포함
 */
@Data
@NoArgsConstructor
public class CenterSearchCriteria {
    /** 시/도 코드 (stdg_ctpv_cd) */
    private String stdgCtpvCd;
    /** 시/군/구 코드 (stdg_sgg_cd) */
    private String stdgSggCd;

    /** 페이징: 요청할 페이지 (0부터 시작) */
    private int page = 0;
    /** 페이징: 한 페이지당 개수 */
    private int size = 10;
}
