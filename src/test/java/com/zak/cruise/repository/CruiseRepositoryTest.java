package com.zak.cruise.repository;

import com.zak.cruise.CruiseApplication;
import com.zak.cruise.entity.Cruise;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@ContextConfiguration(classes = CruiseApplication.class, loader = AnnotationConfigContextLoader.class)
class CruiseRepositoryTest {
    @Autowired
    private  CruiseRepository cruiseRepository;

    @Test
    void findById() {
        Optional<Cruise> newCruise = cruiseRepository.findById(13L);
        Assertions.assertNotNull(newCruise);
    }

    @Test
    void findById2(){
        Optional<Cruise> newCruise = cruiseRepository.findById(134L);
        org.assertj.core.api.Assertions.assertThat(newCruise).isNotNull();
    }

    @Test
    void findAllCurrentCruises() {
        List<Cruise> list = cruiseRepository.findAll();
        Assertions.assertNotNull(list);
    }
}