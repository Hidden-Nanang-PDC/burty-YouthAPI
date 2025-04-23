package org.example.burtyyouthapi.content.controller;

import org.example.burtyyouthapi.content.dto.ContentDto;
import org.example.burtyyouthapi.content.dto.ContentSearchCriteria;
import org.example.burtyyouthapi.content.service.ContentService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 청년 콘텐츠 검색 API 컨트롤러
 * - /api/contents/search 엔드포인트 제공
 */
@RestController
@RequestMapping("/api/contents")
@Tag(name = "Contents", description = "청년 콘텐츠 검색 및 조회 API")
public class ContentController {

    private final ContentService service;

    @Autowired
    public ContentController(ContentService service) {
        this.service = service;
    }

    /**
     * GET /api/contents/search
     * 페이징 조건에 맞춰 콘텐츠 목록을 반환합니다.
     */
    @Operation(
            summary = "콘텐츠 목록 검색",
            description = "페이지 및 크기 조건으로 청년 콘텐츠 목록을 조회합니다."
    )
    @GetMapping("/search")
    public Page<ContentDto> searchContents(@ParameterObject ContentSearchCriteria criteria) {
        return service.searchContents(criteria);
    }
}