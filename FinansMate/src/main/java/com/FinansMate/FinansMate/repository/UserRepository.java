package com.FinansMate.FinansMate.repository;

import com.FinansMate.FinansMate.model.MyUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Long> {
  MyUser findByUsername(String username);
  Optional<MyUser> findByEmail(String email);
  boolean existsByEmail(String e);
  Optional<MyUser> findByEmailIgnoreCase(String email);
}
