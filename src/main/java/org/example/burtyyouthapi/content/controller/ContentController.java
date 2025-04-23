package org.example.burtyyouthapi.content.controller;

import org.example.burtyyouthapi.content.dto.ContentDto;
import org.example.burtyyouthapi.content.dto.ContentFileDto;
import org.example.burtyyouthapi.content.dto.ContentSearchCriteria;
import org.example.burtyyouthapi.content.service.ContentService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.NoSuchElementException;

/**
 * 청년 콘텐츠 검색 및 파일 조회 API 컨트롤러
 * - /api/contents/search  : 목록 (파일 제외)
 * - /api/contents/{pstSn}/file : 첨부파일(Base64) 조회
 */
@RestController
@RequestMapping("/api/contents")
@Tag(name = "Contents", description = "청년 콘텐츠 검색 및 파일 조회 API")
public class ContentController {

    private final ContentService service;

    @Autowired
    public ContentController(ContentService service) {
        this.service = service;
    }

    @Operation(summary = "콘텐츠 목록 검색", description = "페이지 및 크기 조건으로 콘텐츠 목록 조회 (파일 제외)")
    @GetMapping("/search")
    public Page<ContentDto> searchContents(@ParameterObject ContentSearchCriteria criteria) {
        return service.searchContents(criteria);
    }

    @Operation(summary = "콘텐츠 첨부파일 조회", description = "게시물 일련번호로 Base64 첨부파일 반환")
    @GetMapping("/{pstSn}/file")
    public ContentFileDto getContentFile(@PathVariable String pstSn) {
        try {
            return service.getContentFile(pstSn);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}
