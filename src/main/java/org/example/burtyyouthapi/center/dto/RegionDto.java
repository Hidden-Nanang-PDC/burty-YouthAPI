package org.example.burtyyouthapi.center.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 지역 코드 정보를 전송하기 위한 DTO
 * - code: 시도 또는 시군구 코드
 * - name: 코드에 대응하는 명칭
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegionDto {
    private String code;
    private String name;
}
