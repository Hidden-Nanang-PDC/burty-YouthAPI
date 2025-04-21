package org.example.burtyyouthapi.policycode.controller;

import org.example.burtyyouthapi.policycode.dto.PolicyCodeDto;
import org.example.burtyyouthapi.policycode.service.PolicyCodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 정책 코드(필터) API 컨트롤러
 * - /api/policy-codes 엔드포인트에서 그룹별 코드 목록을 제공합니다.
 */
@RestController
@RequestMapping("/api/policy-codes")
public class PolicyCodeController {

    private final PolicyCodeService service;

    public PolicyCodeController(PolicyCodeService service) {
        this.service = service;
    }

    /**
     * GET /api/policy-codes?group={코드그룹명}
     * 요청된 그룹명에 해당하는 코드 목록을 반환합니다.
     *
     * @param group 코드그룹명 (예: "전공조건코드")
     * @return 해당 그룹 코드 목록 (code, name)
     */
    @GetMapping
    public List<PolicyCodeDto> getPolicyCodes(@RequestParam("group") String group) {
        return service.getCodesByGroup(group);
    }
}
