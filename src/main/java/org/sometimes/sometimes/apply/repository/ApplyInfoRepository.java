package org.sometimes.sometimes.apply.repository;

import org.sometimes.sometimes.apply.web.entity.ApplyInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyInfoRepository extends JpaRepository<ApplyInfoEntity, Long> {
}
