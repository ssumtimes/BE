package org.sometimes.sometimes.user.repository;

import org.sometimes.sometimes.user.web.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Boolean existsByUserId(String userId);

    Optional<UserEntity> findByUserId(String userId);
}
