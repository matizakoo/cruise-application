package com.zak.cruise.dto;

import com.zak.cruise.entity.Cruise;
import com.zak.cruise.entity.Status;
import com.zak.cruise.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

@Controller
@Getter
@Setter
public class OrderDTO {
    private Long id;
    private Cruise cruise;
    private Status status;
    private User user;
}
