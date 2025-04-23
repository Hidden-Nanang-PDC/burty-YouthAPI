package org.example.burtyyouthapi.center.service;

import org.example.burtyyouthapi.center.dto.CenterDto;
import org.example.burtyyouthapi.center.dto.CenterSearchCriteria;
import org.example.burtyyouthapi.center.entity.YouthCenter;
import org.example.burtyyouthapi.center.repository.YouthCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * 센터 검색 비즈니스 로직
 */
@Service
public class CenterService {

    private final YouthCenterRepository repository;

    @Autowired
    public CenterService(YouthCenterRepository repository) {
        this.repository = repository;
    }

    /**
     * 시도/시군구 필터와 페이징 정보를 사용해 센터 목록 반환
     */
    public Page<CenterDto> searchCenters(CenterSearchCriteria criteria) {
        Pageable pageable = PageRequest.of(
                criteria.getPage(),
                criteria.getSize(),
                Sort.by("frstRegDt").descending()
        );

        Specification<YouthCenter> specification = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (criteria.getStdgCtpvCd() != null && !criteria.getStdgCtpvCd().isEmpty()) {
                predicates.add(cb.equal(root.get("stdgCtpvCd"), criteria.getStdgCtpvCd()));
            }
            if (criteria.getStdgSggCd() != null && !criteria.getStdgSggCd().isEmpty()) {
                predicates.add(cb.equal(root.get("stdgSggCd"), criteria.getStdgSggCd()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };

        Page<YouthCenter> page = repository.findAll(specification, pageable);
        return page.map(this::toDto);
    }

    /**
     * Entity → DTO 변환
     */
    private CenterDto toDto(YouthCenter c) {
        return new CenterDto(
                c.getCntrSn(),
                c.getStdgCtpvCd(), c.getStdgCtpvCdNm(),
                c.getStdgSggCd(),  c.getStdgSggCdNm(),
                c.getCntrNm(),
                c.getOperInstNm(),
                c.getCntrOperHrCn(),
                c.getCntrUtztnHrCn(),
                c.getCntrAddr(),
                c.getCntrDaddr(),
                c.getCntrTelno(),
                c.getPicFlnm(),
                c.getPicTelno(),
                c.getPicEmlAddr(),
                c.getCntrUrlAddr(),
                c.getCntrGdCn(),
                c.getSbsdFcltEtcCn(),
                c.getFrstRegDt(),
                c.getLastMdfcnDt()
        );
    }
}
