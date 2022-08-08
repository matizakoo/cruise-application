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
    @Value("1")
    private Long id;
    @Column(name = "status_name")
    @Value("ordered")
    private String status_name;

    public Status() {
    }
    public Status(Long id, String status_name){
        this.id = id;
        this.status_name = status_name;
    }

    public Status defaultStatus(){
        return new Status(1L, "ordered");
    }
}
