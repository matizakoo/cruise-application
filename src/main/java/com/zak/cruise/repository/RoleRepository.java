package com.zak.cruise.repository;

import com.zak.cruise.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface RoleRepository extends JpaRepository<com.zak.cruise.entity.Role, Long> {
    @Override
    ArrayList<Role> findAll();
}
