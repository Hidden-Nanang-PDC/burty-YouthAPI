# Burty Youth Policy API
### 1. 정책 검색

- 다양한 필터 조건을 기반으로 정책 목록 조회
- 전공, 취업상태, 특수분야, 소득조건 등 조건 사용 가능
- 페이징, 정렬 지원

---

### 2. 정책 상세 조회

- 목록에서 선택된 정책을 상세히 확인
- 신청방법, 심사방법, 대상 연령, 기관 정보 등 포함

**요청 예시**
```
GET /api/policies/{plcyNo}
```

---

### 3. 필터 조건(정책 코드) 목록 제공

- 검색 조건 드롭다운(전공조건, 취업상태 등)에 필요한 코드 목록을 API로 제공
- 프론트에서 조건 UI를 유동적으로 구성 가능

**요청 예시**
```
GET /api/policy-codes?group=전공조건코드
```

**응답 예시**
```json
[
  { "code": "0011001", "name": "인문계열" },
  { "code": "0011005", "name": "공학계열" },
  ...
]
```

---

## 정책코드 그룹 예시

- 전공조건코드
- 취업상태코드
- 특수분야코드
- 자격학력코드
- 소득조건구분코드
- 정책제공방법코드
- 정책승인상태코드
- 결혼상태코드
- 제공기관그룹코드

---

## API 정리

| 엔드포인트 | 설명 |
|------------|------|
| GET `/api/policies/search` | 필터 조건에 따른 정책 목록 조회 |
| GET `/api/policies/{plcyNo}` | 개별 정책 상세 조회 |
| GET `/api/policy-codes?group=코드그룹명` | 전공, 취업상태 등 조건 코드 목록 조회 |

---

## Entity 예시: Policy

주요 필드 구성은 다음과 같습니다.

- plcyNo: 정책 번호 (PK)
- plcyNm: 정책명
- plcyExplnCn: 정책 설명
- lclsfNm, mclsfNm: 정책 대/중분류명
- sprvsnInstCdNm: 주관기관명
- plcyMajorCd, jobCd, schoolCd: 전공, 취업, 학력 관련 코드
- sprtTrgtMinAge / MaxAge: 지원대상 연령
- aplyYmd: 신청 기간
- 기타: 신청 방법, 심사 방식, 제출 서류 등

---

## 전체 흐름

1. 프론트는 정책 코드 API로 검색 조건(전공, 취업 등)을 동적으로 렌더링
2. 사용자가 필터 조건을 선택하고 검색 요청
3. `/api/policies/search` 호출 → 조건에 맞는 정책 목록 응답
4. 특정 정책 클릭 → `/api/policies/{plcyNo}` 호출 → 상세 정보 표시

---

## 개발 구조

- Controller → Service → Repository → Entity 구조
- 정책(policies), 코드(policy-codes) 도메인 별 분리
- DTO는 검색용, 상세용으로 구분 설계

