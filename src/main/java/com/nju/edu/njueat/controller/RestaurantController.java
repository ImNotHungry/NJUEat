package com.nju.edu.njueat.controller;

import com.nju.edu.njueat.common.response.ResultBody;
import com.nju.edu.njueat.common.response.ServiceStatusCode;
import com.nju.edu.njueat.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 添加评论
     * @return 添加成功
     */
    @PostMapping("/addComment")
    public ResultBody addComment(@RequestParam("userId") int userId, @RequestParam("restaurantId") int restaurantId,
                                 @RequestParam("comment") String comment) {
        restaurantService.addComment(userId, restaurantId, comment);
        return new ResultBody(ServiceStatusCode.OK);
    }

    /**
     * 查看评论
     * @return 评论列表
     */
    @PostMapping("/viewComment")
    public ResultBody viewComment(@RequestParam("restaurantId") int restaurantId) {
        return new ResultBody(ServiceStatusCode.OK, restaurantService.allComment(restaurantId));
    }
}
