package org.example.burtyyouthapi.content.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 청년 콘텐츠 목록 반환용 DTO (파일 제외)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentDto {
    /** 게시물 일련번호 */
    private String pstSn;
    /** 게시물 구분명 */
    private String pstSeNm;
    /** 게시물 제목 */
    private String pstTtl;
    /** 게시물 전체 내용 */
    private String pstWholCn;
    /** 최초 등록 일시 */
    private String frstRegDt;
    /** 최종 수정자명 */
    private String lastMdfrNm;
}
