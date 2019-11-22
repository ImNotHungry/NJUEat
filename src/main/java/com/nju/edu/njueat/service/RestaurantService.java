package com.nju.edu.njueat.service;

import com.alibaba.fastjson.JSONArray;

public interface RestaurantService {
    /**
     * 获得所有食堂
     * @return 食堂列表
     */
    JSONArray allCanteen();

    /**
     * 获取校外餐厅
     * @return 餐厅列表
     */
    JSONArray outsideRestaurant();

    /**
     * 添加评论
     * @param userId 用户id
     * @param restaurantId 餐厅id
     * @param comment 评论
     */
    void addComment(int userId, int restaurantId, String comment);

    /**
     * 查看评论
     * @param restaurantId 餐厅id
     * @return 评论列表
     */
    JSONArray allComment(int restaurantId);
}
