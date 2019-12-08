package com.nju.edu.njueat.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.nju.edu.njueat.model.Food;

import java.util.List;

public interface FoodService {
    /**
     * 添加新的菜品
     *
     * @param food 菜品
     */
    void addNewFood(Food food);

    /**
     * 得到最新的十道菜，根据日期排序，取最近发布的10道菜
     *
     * @return 返回给前端的消息
     */
    JSONArray getNewFoods();

    /**
     * 得到一个餐厅的所有菜品信息
     *
     * @param restaurantId 餐厅ID
     * @return
     */
    List<Food> getAllFoodsInCanteen(int restaurantId);

    /**
     * 得到每日推荐菜品
     * 其实就是个随机种子，随机得到一个菜
     *
     * @return 推荐的菜
     */
    JSONArray getDailyFood();
}
