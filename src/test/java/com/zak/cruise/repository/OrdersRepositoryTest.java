package com.zak.cruise.repository;

import com.zak.cruise.CruiseApplication;
import com.zak.cruise.entity.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ContextConfiguration(classes = CruiseApplication.class, loader = AnnotationConfigContextLoader.class)
@AutoConfigureTestDatabase
class OrdersRepositoryTest {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private CruiseRepository cruiseRepository;
    @Autowired
    private UserRepository userRepository;

//    @Test
//    void saveOrder() {
//        Optional<Cruise> cruise = cruiseRepository.findById(13L);
//        Optional<User> user = userRepository.findByLogin("");
//        Orders orders = new Orders(cruise.get(), new Status(1L, "ordered"), user.get());
//        ordersRepository.save(orders);
//    }

    @Test
    void findAll() {
        Cruise cruise = new Cruise("Around the world", LocalDate.of(2000,2,2),
                LocalTime.now(),1500,45,54, new Route("Gdansk","Grenlandia"),
                new Ship(43,"karasie",5,6, new Staff("DruzynaRR")));
        cruiseRepository.save(cruise);
        List<Orders> list = ordersRepository.findAll();
        System.out.println("Czy to null? " + list.toString());
        Assertions.assertThat(list).isNotNull();
    }

    @Test
    void getNumberOfFreeSeats() {
        List<Orders> list = ordersRepository.findAll();
        Integer integer = ordersRepository.getNumberOfFreeSeats(list.get(0).getId());
        Assertions.assertThat(integer).isNotNull();
    }
}