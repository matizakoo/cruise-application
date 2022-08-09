package com.zak.cruise.service.impl;

import com.zak.cruise.entity.Cruise;
import com.zak.cruise.entity.Order;
import com.zak.cruise.entity.Status;
import com.zak.cruise.entity.User;
import com.zak.cruise.repository.CruiseRepository;
import com.zak.cruise.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderService {
    Logger logger = LoggerFactory.getLogger("Order");
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CruiseService cruiseService;
    @Autowired
    UserService userService;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

//    @Transactional
//    public void save(Cruise cruise, Status status, User user){
//        orderRepository.saveOrder(cruise.getId(), status.getId(), user.getId());
//    }

    @Transactional
    public void saveOrder(Long cruiseid, Long statusid, Integer userid){
        orderRepository.saveOrder(cruiseid, statusid, userid);
    }

    public void save(Long id, String currentLogin){
        Cruise cruise = cruiseService.getCruiseDetails(id); //smiga
        Status status = new Status().defaultStatus();
        User user = userService.getUserDetails(currentLogin).get();

        Order order = new Order(cruise, status, user);
        logger.info("Creating order for cruise id: "+order.getCruise().getId()
                + ", status id: " + order.getStatus().getId()
                + ", user id: " + user.getId());
        saveOrder(cruise.getId(), status.getId(), user.getId());
    }
}
