package com.zak.cruise.entity;

import com.zak.cruise.service.impl.MyUserDetails;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order")
@Getter
@Setter
public class Order {
    @Id
    @Column(name = "idstatus")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "cruise_id_cruise")
    private Cruise cruise;

    @OneToOne
    @JoinColumn(name = "status_id_status")
    private Status status;

    @OneToOne
    @JoinColumn(name = "user_iduser")
    private User user;

    public Order() {
    }

    public Order(Cruise cruise, Status status, User user) {
        this.cruise = cruise;
        this.status = status;
        this.user = user;
    }
}
