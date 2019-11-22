package com.nju.edu.njueat.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
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

    //头像地址
    @Column(name = "avatar_url", length = 255)
    private String avatarUrl;

    public User(){
    }

    public User(int id, String name, String password, String wechatId, String avatarUrl) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.wechatId = wechatId;
        this.avatarUrl = avatarUrl;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}