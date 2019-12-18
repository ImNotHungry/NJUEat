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
}
