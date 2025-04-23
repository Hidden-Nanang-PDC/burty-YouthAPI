package org.example.burtyyouthapi.policycode.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.burtyyouthapi.policycode.dto.PolicyCodeDto;
import org.example.burtyyouthapi.policycode.service.PolicyCodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 정책 코드(필터) API 컨트롤러
 * - /api/policy-codes 엔드포인트에서 그룹별 코드 목록을 제공합니다.
 */
@Tag(name = "Policy-code", description = "정책 필터 카테고리 목록 제공")
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
    @Operation(
            summary = "카테고리 키워드 제공",
            description = "group값 목록<br/>"
                    + "전공조건코드, 결혼상태코드, 사업기간구분코드, 소득조건구분코드<br/>"
                    + "신청기간구분코드, 자격학력코드, 정책승인상태코드, 정책제공방법코드<br/>"
                    + "제공기관그룹코드, 취업상태코드, 특수분야코드"
    )
    @GetMapping
    public List<PolicyCodeDto> getPolicyCodes(@RequestParam("group") String group) {
        return service.getCodesByGroup(group);
    }
}
