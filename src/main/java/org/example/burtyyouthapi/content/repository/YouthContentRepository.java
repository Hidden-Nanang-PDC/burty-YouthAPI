package org.example.burtyyouthapi.content.repository;

import org.example.burtyyouthapi.content.entity.YouthContent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * YouthContent 엔티티에 대한 JPA Repository
 */
public interface YouthContentRepository extends JpaRepository<YouthContent, String> {
}