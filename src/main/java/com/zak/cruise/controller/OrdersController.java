package com.zak.cruise.controller;

import com.zak.cruise.entity.Orders;
import com.zak.cruise.service.impl.OrdersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class OrdersController {
    Logger logger = LoggerFactory.getLogger("Order controller");
    @Autowired
    OrdersService orderService;


    @GetMapping("/orders")
    public String showAll(Model model) {
        logger.info("showAll method");
        List<Orders> orders = orderService.findAllOrders();
        model.addAttribute("orders", orders);
        return "orders";
    }

    @PostMapping("/listOfOrders")
    public String confirmOrder(@RequestParam("orderid") Integer orderid, RedirectAttributes redirectAttributes){
        logger.info(""+orderid);
        orderService.confirmOrder(orderid);
        return "redirect:/orders";
    }
}
