package com.nju.edu.njueat.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "dish")
@Getter
@Setter
public class Dish implements Serializable {
    //自增id
    @Id
    @Column(name = "id", nullable = false, length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //菜名
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    //餐馆id
    @Column(name = "restaurant_id", nullable = false, length = 11)
    private int restaurantId;

    //价格
    @Column(name = "price", nullable = false, columnDefinition = "double(10,2) default '0.00'")
    private double price;

    //推出日期
    @Column(name = "launch_date", nullable = false)
    private LocalDateTime launchDate;

    //描述
    @Column(name = "description", nullable = false, length = 255)
    private String description;
}
