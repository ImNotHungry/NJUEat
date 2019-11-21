package com.nju.edu.njueat.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
public class Restaurant implements Serializable {
    //自增id
    @Id
    @Column(name = "id", nullable = false, length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //餐馆名称
    @Column(name = "name", nullable = false, length = 30)
    private String name;

    //地址
    @Column(name = "address", nullable = false, length = 50)
    private String address;

    //营业时间
    @Column(name = "service_time", nullable = false, length = 50)
    private String serviceTime;

    //描述
    @Column(name = "description")
    private String description;

    //是否为食堂
    @Column(name = "is_canteen", nullable = false, columnDefinition = "tinyint default 0", length = 1)
    private boolean isCanteen;

    //图片地址
    @Column(name = "picture_url", length = 255)
    private String pictureUrl;

    public Restaurant() {
    }

    public Restaurant(int id, String name, String address, String serviceTime, String description, boolean isCanteen, String pictureUrl) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.serviceTime = serviceTime;
        this.description = description;
        this.isCanteen = isCanteen;
        this.pictureUrl = pictureUrl;
    }
}
