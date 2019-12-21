package com.nju.edu.njueat.controller;

import com.nju.edu.njueat.common.response.ResultBody;
import com.nju.edu.njueat.common.response.ServiceStatusCode;
import com.nju.edu.njueat.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    /**
     * 获取所有食堂
     * @return 食堂列表
     */
    @PostMapping("/allCanteen")
    public ResultBody allCanteen() {
        return new ResultBody(ServiceStatusCode.OK, restaurantService.allCanteen());
    }

    /**
     * 获取校外餐厅
     * @return 校外餐厅列表（10个）
     */
    @PostMapping("/outside")
    public ResultBody outside() {
        return new ResultBody(ServiceStatusCode.OK, restaurantService.outsideRestaurant());
    }
}
