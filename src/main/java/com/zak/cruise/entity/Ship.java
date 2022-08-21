package com.zak.cruise.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ship")
@Getter
@Setter
public class Ship {
    @Id
    @Column(name = "idShip")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unique_id")
    private int uniqueId;

    @Column(name = "unique_name")
    private String uniqueName;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "number_of_ports")
    private int numberOfPorts;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_name_id_staff")
    private Staff staffName;

    public Ship() {
    }

    public Ship(int uniqueId, String uniqueName, int capacity, int numberOfPorts, Staff staffName) {
        this.uniqueId = uniqueId;
        this.uniqueName = uniqueName;
        this.capacity = capacity;
        this.numberOfPorts = numberOfPorts;
        this.staffName = staffName;
    }
}
