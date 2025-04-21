package org.example.burtyyouthapi.policy.repository;

import org.example.burtyyouthapi.model.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Policy 엔티티에 대한 CRUD 및 Specification 기반 검색 지원
 */
public interface PolicyRepository
        extends JpaRepository<Policy, String>,
        JpaSpecificationExecutor<Policy> {
}
