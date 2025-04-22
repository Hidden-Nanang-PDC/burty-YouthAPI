package org.example.burtyyouthapi.center.repository;

import org.example.burtyyouthapi.center.dto.RegionDto;
import org.example.burtyyouthapi.center.entity.YouthCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * YouthCenter 엔티티에 대한 JPA Repository
 * - 센터 테이블에서 중복 없는 시도/시군구 코드를 추출하는 커스텀 쿼리 포함
 */
public interface YouthCenterRepository extends JpaRepository<YouthCenter, String> {

    /**
     * DB에 저장된 모든 센터에서 중복 없는 시도 코드 목록 조회
     */
    @Query("SELECT DISTINCT new org.example.burtyyouthapi.center.dto.RegionDto(c.stdgCtpvCd, c.stdgCtpvCdNm) "
            + "FROM YouthCenter c")
    List<RegionDto> findDistinctProvinces();

    /**
     * 특정 시도 코드에 속하는 중복 없는 시군구 코드 목록 조회
     * @param ctpvCd 시도 코드
     */
    @Query("SELECT DISTINCT new org.example.burtyyouthapi.center.dto.RegionDto(c.stdgSggCd, c.stdgSggCdNm) "
            + "FROM YouthCenter c "
            + "WHERE c.stdgCtpvCd = :ctpvCd")
    List<RegionDto> findDistinctDistrictsByProvince(@Param("ctpvCd") String ctpvCd);
}
