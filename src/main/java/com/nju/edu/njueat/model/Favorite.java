package com.nju.edu.njueat.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "favorite")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
}
