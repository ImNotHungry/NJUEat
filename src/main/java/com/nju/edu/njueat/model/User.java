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
    @Column(name = "id", nullable = false, length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //用户名
    @Column(name = "name", nullable = false, length = 30)
    private String name;

    //登录密码
    @Column(name = "password", nullable = false, length = 128)
    private String password;

    //微信号
    @Column(name = "wechat_id", length = 30)
    private String wechatId;

    public User(){

    }

    public User(int id, String name, String password, String wechatId) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.wechatId = wechatId;
    }
}