package com.zak.cruise.service.impl;

import com.zak.cruise.entity.Cruise;
import com.zak.cruise.entity.Orders;
import com.zak.cruise.entity.Status;
import com.zak.cruise.entity.User;
import com.zak.cruise.repository.OrdersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrdersService {
    Logger logger = LoggerFactory.getLogger("Orders");
    @Autowired
    OrdersRepository orderRepository;
    @Autowired
    CruiseService cruiseService;
    @Autowired
    UserService userService;

    public OrdersService(OrdersRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Orders> findAllOrders() {
        logger.info(orderRepository.findAll().toString());
        return (List<Orders>) orderRepository.findAll();
    }

    @Transactional
    public void saveOrder(Long cruiseid, Long statusid, Integer userid){
        orderRepository.saveOrder(cruiseid, statusid, userid);
    }

    @Transactional
    public void save(Orders orders){
        orderRepository.save(orders);
    }

    public void save(Long id, String currentLogin){
        Cruise cruise = cruiseService.getCruiseDetails(id); //smiga
        Status status = new Status().defaultStatus();
        User user = userService.getUserDetails(currentLogin).get();

        Orders order = new Orders(cruise, status, user);
        logger.info("Creating order for cruise id: "+order.getCruise().getId()
                + ", status id: " + order.getStatus().getId()
                + ", user id: " + user.getId());
        saveOrder(cruise.getId(), status.getId(), user.getId());
    }

    public void confirmOrder(Integer orderid){
        Orders orders = orderRepository.findById(Long.valueOf(orderid)).get();
        orders.getStatus().setId(2L);
        save(orders);
    }
}
