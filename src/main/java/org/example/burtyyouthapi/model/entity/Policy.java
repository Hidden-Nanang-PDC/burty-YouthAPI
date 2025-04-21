package org.example.burtyyouthapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DB 테이블 `policy` 매핑 엔티티
 * - 청년정책API로 수집한 정책 데이터를 저장
 * - 테이블의 모든 컬럼을 필드로 포함
 */
@Entity
@Table(name = "policy")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policy {

    // 정책번호 (Primary Key)
    @Id
    @Column(name = "plcy_no", length = 50)
    private String plcyNo;

    // 기본계획 관련 정보
    @Column(name = "bsc_plan_cycl")
    private String bscPlanCycl;

    @Column(name = "bsc_plan_plcy_way_no")
    private String bscPlanPlcyWayNo;

    @Column(name = "bsc_plan_fcs_asmt_no")
    private String bscPlanFcsAsmtNo;

    @Column(name = "bsc_plan_asmt_no")
    private String bscPlanAsmtNo;

    // 기관 및 제공 관련 정보
    @Column(name = "pvsn_inst_group_cd")
    private String pvsnInstGroupCd;

    @Column(name = "plcy_pvsn_mthd_cd")
    private String plcyPvsnMthdCd;

    @Column(name = "plcy_aprv_stts_cd")
    private String plcyAprvSttsCd;

    // 정책 기본 정보
    @Column(name = "plcy_nm")
    private String plcyNm;

    @Column(name = "plcy_kywd_nm", columnDefinition = "TEXT")
    private String plcyKywdNm;

    @Column(name = "plcy_expln_cn", columnDefinition = "TEXT")
    private String plcyExplnCn;

    // 분류 정보
    @Column(name = "lclsf_nm")
    private String lclsfNm;

    @Column(name = "mclsf_nm")
    private String mclsfNm;

    // 지원 및 담당자 정보
    @Column(name = "plcy_sprt_cn", columnDefinition = "TEXT")
    private String plcySprtCn;

    @Column(name = "sprvsn_inst_cd")
    private String sprvsnInstCd;

    @Column(name = "sprvsn_inst_cd_nm")
    private String sprvsnInstCdNm;

    @Column(name = "sprvsn_inst_pic_nm")
    private String sprvsnInstPicNm;

    @Column(name = "oper_inst_cd")
    private String operInstCd;

    @Column(name = "oper_inst_cd_nm")
    private String operInstCdNm;

    @Column(name = "oper_inst_pic_nm")
    private String operInstPicNm;

    // 지원 규모 제한 및 신청/사업 기간
    @Column(name = "sprt_scl_lmt_yn")
    private String sprtSclLmtYn;

    @Column(name = "aply_prd_se_cd")
    private String aplyPrdSeCd;

    @Column(name = "biz_prd_se_cd")
    private String bizPrdSeCd;

    @Column(name = "biz_prd_bgng_ymd")
    private String bizPrdBgngYmd;

    @Column(name = "biz_prd_end_ymd")
    private String bizPrdEndYmd;

    @Column(name = "biz_prd_etc_cn", columnDefinition = "TEXT")
    private String bizPrdEtcCn;

    // 신청 및 심사 방법
    @Column(name = "plcy_aply_mthd_cn", columnDefinition = "TEXT")
    private String plcyAplyMthdCn;

    @Column(name = "srng_mthd_cn", columnDefinition = "TEXT")
    private String srngMthdCn;

    @Column(name = "aply_url_addr", columnDefinition = "TEXT")
    private String aplyUrlAddr;

    @Column(name = "sbmsn_dcmnt_cn", columnDefinition = "TEXT")
    private String sbmsnDcmntCn;

    @Column(name = "etc_mttr_cn", columnDefinition = "TEXT")
    private String etcMttrCn;

    // 참고 URL
    @Column(name = "ref_url_addr1", columnDefinition = "TEXT")
    private String refUrlAddr1;

    @Column(name = "ref_url_addr2", columnDefinition = "TEXT")
    private String refUrlAddr2;

    // 지원 규모 및 대상 연령 등
    @Column(name = "sprt_scl_cnt")
    private String sprtSclCnt;

    @Column(name = "sprt_arvl_seq_yn")
    private String sprtArvlSeqYn;

    @Column(name = "sprt_trgt_min_age")
    private String sprtTrgtMinAge;

    @Column(name = "sprt_trgt_max_age")
    private String sprtTrgtMaxAge;

    @Column(name = "sprt_trgt_age_lmt_yn")
    private String sprtTrgtAgeLmtYn;

    // 추가 조건 및 조회수
    @Column(name = "mrg_stts_cd")
    private String mrgSttsCd;

    @Column(name = "earn_cnd_se_cd")
    private String earnCndSeCd;

    @Column(name = "earn_min_amt")
    private String earnMinAmt;

    @Column(name = "earn_max_amt")
    private String earnMaxAmt;

    @Column(name = "earn_etc_cn", columnDefinition = "TEXT")
    private String earnEtcCn;

    @Column(name = "add_aply_qlfc_cnd_cn", columnDefinition = "TEXT")
    private String addAplyQlfcCndCn;

    @Column(name = "ptcp_prp_trgt_cn", columnDefinition = "TEXT")
    private String ptcpPrpTrgtCn;

    @Column(name = "inq_cnt")
    private String inqCnt;

    // 등록 기관 정보
    @Column(name = "rgtr_inst_cd")
    private String rgtrInstCd;

    @Column(name = "rgtr_inst_cd_nm")
    private String rgtrInstCdNm;

    @Column(name = "rgtr_up_inst_cd")
    private String rgtrUpInstCd;

    @Column(name = "rgtr_up_inst_cd_nm")
    private String rgtrUpInstCdNm;

    @Column(name = "rgtr_hghrk_inst_cd")
    private String rgtrHghrkInstCd;

    @Column(name = "rgtr_hghrk_inst_cd_nm")
    private String rgtrHghrkInstCdNm;

    // 지역 및 추가 코드 정보
    @Column(name = "zip_cd", columnDefinition = "TEXT")
    private String zipCd;

    @Column(name = "plcy_major_cd")
    private String plcyMajorCd;

    @Column(name = "job_cd")
    private String jobCd;

    @Column(name = "school_cd")
    private String schoolCd;

    // 신청 기간
    @Column(name = "aply_ymd")
    private String aplyYmd;

    // 등록 일자
    @Column(name = "frst_reg_dt")
    private String frstRegDt;

    @Column(name = "last_mdfcn_dt")
    private String lastMdfcnDt;

    // 정책 특화 요건 코드
    @Column(name = "s_biz_cd")
    private String sBizCd;
}
