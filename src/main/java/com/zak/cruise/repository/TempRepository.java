package com.zak.cruise.repository;

import com.zak.cruise.entity.TempUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TempRepository extends JpaRepository<TempUser, Long> {
}
