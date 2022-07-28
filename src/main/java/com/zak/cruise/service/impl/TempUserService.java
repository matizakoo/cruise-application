package com.zak.cruise.service.impl;

import com.zak.cruise.entity.TempUser;
import com.zak.cruise.repository.TempRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
public class TempUserService {
    @Autowired
    TempRepository tempRepository;


}
