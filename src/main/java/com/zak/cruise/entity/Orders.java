package com.zak.cruise.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Orders {
    @Id
    @Column(name = "idstatus")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cruise_id_cruise")
    private Cruise cruise;

    @ManyToOne
    @JoinColumn(name = "status_id_status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_iduser")
    private User user;

    public Orders() {
    }

    public Orders(Cruise cruise, Status status, User user) {
        this.cruise = cruise;
        this.status = status;
        this.user = user;
    }

    public Orders(Long id, Cruise cruise, Status status, User user) {
        this.id = id;
        this.cruise = cruise;
        this.status = status;
        this.user = user;
    }

    public Long getId() {
        return id;
    }
}
