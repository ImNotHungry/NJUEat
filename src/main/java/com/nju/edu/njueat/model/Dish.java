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

    //窗口
    @Column(name = "window", nullable = false, length = 11)
    private int window;

    //推出日期
    @Column(name = "launch_date", nullable = false)
    private LocalDateTime launchDate;

    //描述
    @Column(name = "description", nullable = false, length = 255)
    private String description;

    //图片地址
    @Column(name = "picture_url", length = 255)
    private String pictureUrl;

    public Dish() {
    }

    public Dish(int id, String name, int restaurantId, double price, int window, LocalDateTime launchDate, String description, String pictureUrl) {
        this.id = id;
        this.name = name;
        this.restaurantId = restaurantId;
        this.price = price;
        this.window = window;
        this.launchDate = launchDate;
        this.description = description;
        this.pictureUrl = pictureUrl;
    }
}
