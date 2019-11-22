package com.nju.edu.njueat.repository;

import com.nju.edu.njueat.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    /**
     * 获取所有食堂
     * @return 食堂列表
     */
    List<Restaurant> findAllByIsCanteen(boolean isCanteen);
}
