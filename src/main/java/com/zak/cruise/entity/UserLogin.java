package com.zak.cruise.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserLogin {
}
