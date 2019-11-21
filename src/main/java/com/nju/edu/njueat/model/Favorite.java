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

    //食堂id
    @Column(name = "restaurant_id", nullable = false, length = 11)
    private int restaurantId;

    //菜品id
    @Column(name = "food_id", nullable = false, length = 11)
    private int foodId;

    public Favorite() {
    }

    public Favorite(int id, int userId, int restaurantId, int foodId) {
        this.id = id;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.foodId = foodId;
    }
}
