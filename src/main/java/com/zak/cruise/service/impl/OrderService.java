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

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

//    @Transactional
//    public void save(Cruise cruise, Status status, User user){
//        orderRepository.saveOrder(cruise.getId(), status.getId(), user.getId());
//    }
    @Transactional
    public void save(Cruise cruise, Status status, User user){
        Order order = new Order(cruise, status, user);
        logger.info(""+order.getCruise().getId());
        logger.info(""+order.getStatus().getId());
        logger.info(""+order.getUser().getId());
        orderRepository.saveOrder(cruise.getId(), status.getId(), user.getId());
    }
}
