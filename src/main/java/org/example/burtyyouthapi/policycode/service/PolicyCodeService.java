package org.example.burtyyouthapi.policycode.service;

import org.example.burtyyouthapi.policycode.dto.PolicyCodeDto;
import org.example.burtyyouthapi.policycode.entity.PolicyCode;
import org.example.burtyyouthapi.policycode.repository.PolicyCodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 정책 코드(필터) 조회 비즈니스 로직
 */
@Service
public class PolicyCodeService {

    private final PolicyCodeRepository repository;

    public PolicyCodeService(PolicyCodeRepository repository) {
        this.repository = repository;
    }

    /**
     * 그룹명에 해당하는 정책 코드 목록을 DTO 형태로 반환
     * @param groupName 코드그룹명 (예: "전공조건코드")
     * @return PolicyCodeDto 리스트
     */
    public List<PolicyCodeDto> getCodesByGroup(String groupName) {
        List<PolicyCode> entities = repository.findByCdGroupNm(groupName);
        return entities.stream()
                .map(pc -> new PolicyCodeDto(pc.getComCd(), pc.getCdNm()))
                .collect(Collectors.toList());
    }
}
