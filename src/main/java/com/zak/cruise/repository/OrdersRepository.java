package com.zak.cruise.repository;

import com.zak.cruise.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long> {
    @Modifying
    @Transactional
//    @Query(value = "INSERT INTO order(cruise_id_cruise, status_id_status, user_iduser) VALUES cruise_id_cruise=:idcruise,status_id_status=:idstatus,user_iduser=:iduser", nativeQuery = true)
    @Query(value = "INSERT INTO Cruise.orders(cruise_id_cruise, status_id_status, user_iduser) VALUES (:idcruise, :idstatus, :iduser)", nativeQuery = true)
    void saveOrder(Long idcruise, Long idstatus, Integer iduser);

    @Override
    ArrayList<Orders> findAll();
}
