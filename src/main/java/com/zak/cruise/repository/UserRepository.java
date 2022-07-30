package com.zak.cruise.repository;

import com.zak.cruise.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT count(email) FROM user WHERE email = :email", nativeQuery = true)
    int findByEmail(String email);
}
