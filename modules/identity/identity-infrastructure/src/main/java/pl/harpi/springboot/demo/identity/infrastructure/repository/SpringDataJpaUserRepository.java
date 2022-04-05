package pl.harpi.springboot.demo.identity.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface SpringDataJpaUserRepository extends JpaRepository<UserEntity, Long> {
  Optional<UserEntity> findByUid(String uid);
}
