package org.example.burtyyouthapi.content.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 청년 콘텐츠 첨부파일 전용 DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentFileDto {
    /** 게시물 일련번호 */
    private String pstSn;
    /** Base64 인코딩된 첨부파일 */
    private String atchFile;
}
