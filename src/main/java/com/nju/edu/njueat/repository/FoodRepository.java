package com.nju.edu.njueat.repository;

import com.nju.edu.njueat.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food,Integer> {

    @Query(value = "from Food order by launchDate desc")
    List<Food> getNewFoods();

    @Query(value = "from Food where restaurantId= :rid order by launchDate desc ")
    List<Food> getOneCanteenFoods(@Param("rid") int restaurantId);

    Food getById(int id);

}
