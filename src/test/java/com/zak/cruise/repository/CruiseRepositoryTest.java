package com.zak.cruise.repository;

import com.zak.cruise.CruiseApplication;
import com.zak.cruise.entity.Cruise;
import com.zak.cruise.entity.Route;
import com.zak.cruise.entity.Ship;
import com.zak.cruise.entity.Staff;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@ContextConfiguration(classes = CruiseApplication.class, loader = AnnotationConfigContextLoader.class)
class CruiseRepositoryTest {
    @Autowired
    private  CruiseRepository cruiseRepository;

    @Test
    void findById() {
//        Cruise cruise = new Cruise("New Cruise",
//                LocalDate.of(2022,2,2),
//                LocalTime.now(),
//                5,
//                15,
//                412,
//                new Route("Gdansk","Sopot"),
//                new Ship(3, "Zdrapa", 5, 4, new Staff("Ziomale")));
//        cruiseRepository.save(cruise);
        Optional<Cruise> newCruise = cruiseRepository.findById(13L);
        Assertions.assertNotNull(newCruise);
    }

    @Test
    void findAllCurrentCruises() {
        List<Cruise> list = cruiseRepository.findAll();
        Assertions.assertNotNull(list);
    }
}