package com.nju.edu.njueat.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "food")
public class Food implements Serializable {
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
    @Column(name = "window", nullable = false, length = 255)
    private String window;

    //推出日期
    @Column(name = "launch_date", nullable = false)
    private LocalDateTime launchDate;

    //描述
    @Column(name = "description", nullable = false, length = 255)
    private String description;

    //图片地址
    @Column(name = "picture_url", length = 255)
    private String pictureUrl;

    public Food() {
    }

    public Food(int id, String name, int restaurantId, double price, String window, LocalDateTime launchDate, String description, String pictureUrl) {
        this.id = id;
        this.name = name;
        this.restaurantId = restaurantId;
        this.price = price;
        this.window = window;
        this.launchDate = launchDate;
        this.description = description;
        this.pictureUrl = pictureUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getWindow() {
        return window;
    }

    public void setWindow(String window) {
        this.window = window;
    }

    public LocalDateTime getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDateTime launchDate) {
        this.launchDate = launchDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
