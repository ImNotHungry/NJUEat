package com.nju.edu.njueat.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "favorite")
@Getter
@Setter
public class Favorite implements Serializable {
    //自增id
    @Id
    @Column(name = "id", nullable = false, length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //用户id
    @Column(name = "user_id", nullable = false, length = 11)
    private int userId;

    //菜品id
    @Column(name = "dish_id", nullable = false, length = 11)
    private int dishId;
}
