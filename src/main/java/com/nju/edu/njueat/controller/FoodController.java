package com.nju.edu.njueat.controller;

import com.nju.edu.njueat.common.response.ResultBody;
import com.nju.edu.njueat.common.response.ServiceStatusCode;
import com.nju.edu.njueat.model.Food;
import com.nju.edu.njueat.service.FoodService;
import com.nju.edu.njueat.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;
    @Autowired
    private Environment environment;

    /**
     * 新增菜品
     *
     * @param foodName     菜名
     * @param restaurantId 餐厅
     * @param window       窗口号
     * @param description  描述
     * @param price        价格
     * @param foodPicture  图片文件
     * @return OK
     */
    @PostMapping("/addFood")
    public ResultBody addNewFood(@RequestParam("foodName") String foodName,
                                 @RequestParam("restaurantId") int restaurantId,
                                 @RequestParam("window") int window,
                                 @RequestParam("description") String description,
                                 @RequestParam("price") double price,
                                 @RequestParam("foodPicture") MultipartFile foodPicture) {
        String pictureParentPath = environment.getProperty("food.picture.parent.dir");
        String picturePath = FileUtil.saveOrCoverImage(pictureParentPath, foodPicture, System.currentTimeMillis() + "");
        Food food = new Food();
        food.setDescription(description);
        food.setName(foodName);
        food.setPrice(price);
        food.setWindow(window);
        food.setRestaurantId(restaurantId);
        food.setPictureUrl(picturePath);
        foodService.addNewFood(food);
        return new ResultBody(ServiceStatusCode.OK);

    }

    /**
     * 获取最近的新菜品
     *
     * @return response
     */
    @PostMapping("/new")
    public ResultBody getNewFood() {
        return new ResultBody(ServiceStatusCode.OK, foodService.getNewFoods());
    }

    /**
     * 获取某个餐厅的所有菜品
     *
     * @param restaurantId 菜品ID
     * @return 返回消息
     */
    @PostMapping("/all")
    public ResultBody getOneCanteenAllFoods(@RequestParam("restaurantId") int restaurantId) {
        return new ResultBody(ServiceStatusCode.OK, foodService.getAllFoodsInCanteen(restaurantId));
    }

    /**
     * 获取每日的推荐菜品
     * 垃圾random实现的
     *
     * @return 假装能够实现推荐的菜品
     */
    @PostMapping("/random")
    public ResultBody getDailyRecommendFoods() {
        return new ResultBody(ServiceStatusCode.OK, foodService.getDailyFood());
    }

}
