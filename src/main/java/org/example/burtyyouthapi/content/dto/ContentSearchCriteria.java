package org.example.burtyyouthapi.content.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 청년 콘텐츠 검색용 파라미터 DTO
 * - 페이징 정보 포함
 */
@Data
@NoArgsConstructor
public class ContentSearchCriteria {
    /** 요청할 페이지 (0부터 시작) */
    private int page = 0;
    /** 한 페이지당 아이템 수 */
    private int size = 10;
}