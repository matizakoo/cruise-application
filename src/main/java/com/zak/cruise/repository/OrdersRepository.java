package com.zak.cruise.repository;

import com.zak.cruise.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.stereotype.Repository;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long> {
    @Modifying
    @Transactional
//    @Query(value = "INSERT INTO order(cruise_id_cruise, status_id_status, user_iduser) VALUES cruise_id_cruise=:idcruise,status_id_status=:idstatus,user_iduser=:iduser", nativeQuery = true)
    @Query(value = "INSERT INTO Cruise.orders(cruise_id_cruise, status_id_status, user_iduser) VALUES (:idcruise, :idstatus, :iduser)", nativeQuery = true)
    void saveOrder(Long idcruise, Long idstatus, Integer iduser);

    @Override
    ArrayList<Orders> findAll();

    //doesnt work:(
//    @Query(value = "SELECT cruise_id_cruise, COUNT(user_iduser) FROM orders GROUP BY cruise_id_cruise ORDER BY COUNT(user_iduser) DESC", nativeQuery = true)

//    Map<String, Integer> areAvaliableSeats();

    @Query(value = "select distinct cruise_id_cruise from orders", nativeQuery = true)
    List<Integer> getAllIdCruise();

    @Query(value = "select count(cruise_id_cruise) from orders where cruise_id_cruise = :idcruise", nativeQuery = true)
    Integer getNumberOfFreeSeats(Long idcruise);
}
