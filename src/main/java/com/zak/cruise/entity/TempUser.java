package com.zak.cruise.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "temp")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TempUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    public TempUser(String name) {
        this.name = name;
    }
    public TempUser() {
    }
}
