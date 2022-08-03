package com.zak.cruise.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "staff_name")
@Getter
@Setter
public class Staff {
    @Id
    @Column(name = "id_staff")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "staff_name")
    private String staffName;

    public Staff() {
    }

    public Staff(String staffName) {
        this.staffName = staffName;
    }
}
