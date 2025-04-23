package org.example.burtyyouthapi.center.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 센터 목록 및 상세에 반환할 데이터 DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CenterDto {
    /** 센터 일련번호 (PK) */
    private String cntrSn;

    /** 시/도 코드 */
    private String stdgCtpvCd;
    /** 시/도 코드명 */
    private String stdgCtpvCdNm;

    /** 시/군/구 코드 */
    private String stdgSggCd;
    /** 시/군/구 코드명 */
    private String stdgSggCdNm;

    /** 센터명 */
    private String cntrNm;
    /** 운영기관명 */
    private String operInstNm;

    /** 센터운영시간내용 */
    private String cntrOperHrCn;
    /** 센터이용시간내용 */
    private String cntrUtztnHrCn;

    /** 센터주소 */
    private String cntrAddr;
    /** 센터상세주소 */
    private String cntrDaddr;

    /** 센터전화번호 */
    private String cntrTelno;

    /** 담당자성명 */
    private String picFlnm;
    /** 담당자전화번호 */
    private String picTelno;
    /** 담당자이메일주소 */
    private String picEmlAddr;

    /** 센터URL주소 */
    private String cntrUrlAddr;
    /** 센터안내내용 */
    private String cntrGdCn;
    /** 부대시설기타내용 */
    private String sbsdFcltEtcCn;

    /** 최초등록일시 */
    private String frstRegDt;
    /** 최종수정일시 */
    private String lastMdfcnDt;
}
