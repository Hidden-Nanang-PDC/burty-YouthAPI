package org.example.burtyyouthapi.content.service;

import org.example.burtyyouthapi.content.dto.ContentDto;
import org.example.burtyyouthapi.content.dto.ContentFileDto;
import org.example.burtyyouthapi.content.dto.ContentSearchCriteria;
import org.example.burtyyouthapi.content.entity.YouthContent;
import org.example.burtyyouthapi.content.repository.YouthContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ContentService {

    private final YouthContentRepository repository;

    @Autowired
    public ContentService(YouthContentRepository repository) {
        this.repository = repository;
    }

    /**
     * 페이징 조건에 맞춰 콘텐츠 목록 반환 (파일 제외)
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
     * 특정 콘텐츠의 첨부파일(Base64)만 반환
     * @param pstSn 게시물 일련번호
     * @throws NoSuchElementException 해당 항목이 없으면 예외 발생
     */
    public ContentFileDto getContentFile(String pstSn) {
        YouthContent entity = repository.findById(pstSn)
                .orElseThrow(() -> new NoSuchElementException("Content not found: " + pstSn));
        return new ContentFileDto(entity.getPstSn(), entity.getAtchFile());
    }

    // 기존 toDto 변환 (파일 제외)
    private ContentDto toDto(YouthContent c) {
        return new ContentDto(
                c.getPstSn(),
                c.getPstSeNm(),
                c.getPstTtl(),
                c.getPstWholCn(),
                c.getFrstRegDt(),
                c.getLastMdfrNm()
        );
    }
}
