package org.example.burtyyouthapi.content.service;

import org.example.burtyyouthapi.content.dto.ContentDto;
import org.example.burtyyouthapi.content.dto.ContentSearchCriteria;
import org.example.burtyyouthapi.content.entity.YouthContent;
import org.example.burtyyouthapi.content.repository.YouthContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * 청년 콘텐츠 검색 비즈니스 로직
 */
@Service
public class ContentService {

    private final YouthContentRepository repository;

    @Autowired
    public ContentService(YouthContentRepository repository) {
        this.repository = repository;
    }

    /**
     * 페이징 조건에 맞춰 콘텐츠 목록 반환
     */
    public Page<ContentDto> searchContents(ContentSearchCriteria criteria) {
        Pageable pageable = PageRequest.of(
                criteria.getPage(),
                criteria.getSize(),
                Sort.by("frstRegDt").descending()
        );
        return repository.findAll(pageable)
                .map(this::toDto);
    }

    /**
     * Entity → DTO 변환
     */
    private ContentDto toDto(YouthContent c) {
        return new ContentDto(
                c.getPstSn(),
                c.getPstSeNm(),
                c.getPstTtl(),
                c.getAtchFile(),
                c.getPstWholCn(),
                c.getFrstRegDt(),
                c.getLastMdfrNm()
        );
    }
}