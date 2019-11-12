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

    //联系方式
    @Column(name = "contact", nullable = false, length = 50)
    private String contact;

    //营业时间
    @Column(name = "service_time", nullable = false, length = 50)
    private String serviceTime;

    //描述
    @Column(name = "description")
    private String description;

    //是否为食堂
    @Column(name = "is_canteen", nullable = false, columnDefinition = "tinyint default 0", length = 1)
    private boolean isCanteen;

    public Restaurant() {
    }

    public Restaurant(int id, String name, String address, String contact, String serviceTime, String description) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.serviceTime = serviceTime;
        this.description = description;
    }
}
