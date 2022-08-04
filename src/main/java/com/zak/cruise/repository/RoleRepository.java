package com.zak.cruise.repository;

import com.zak.cruise.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RoleRepository extends JpaRepository<com.zak.cruise.entity.Role, Long> {
    ArrayList<Role> findAllByRole();
}
