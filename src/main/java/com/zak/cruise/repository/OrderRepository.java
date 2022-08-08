package com.zak.cruise.repository;

import com.zak.cruise.entity.Cruise;
import com.zak.cruise.entity.Order;
import com.zak.cruise.entity.Status;
import com.zak.cruise.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Modifying
    @Transactional
//    @Query(value = "INSERT INTO order(cruise_id_cruise, status_id_status, user_iduser) VALUES cruise_id_cruise=:idcruise,status_id_status=:idstatus,user_iduser=:iduser", nativeQuery = true)
    @Query(value = "INSERT INTO Cruise.order(cruise_id_cruise, status_id_status, user_iduser) VALUES (:idcruise, :idstatus, :iduser)" , nativeQuery = true)
    void saveOrder(Long idcruise, Long idstatus, Integer iduser);
}
