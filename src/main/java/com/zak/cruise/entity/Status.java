package com.zak.cruise.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Table(name = "status")
@Getter
@Setter
public class Status {
    @Id
    @Column(name = "idstatus")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "status_name")
    @Value("1")
    private String status_name;

    public Status() {
    }
}
