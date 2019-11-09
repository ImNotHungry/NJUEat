package com.nju.edu.njueat.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User implements Serializable {
    //自增id
    @Id
    @Column(length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //登录密码
    @Column(nullable = false, length = 128)
    private String password;

    //用户名
    @Column(nullable = false, length = 30)
    private String username;

    public User(){

    }

    public User(int id, String password, String username) {
        this.id = id;
        this.password = password;
        this.username = username;
    }
}