package com.nju.edu.njueat.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nju.edu.njueat.model.Food;
import com.nju.edu.njueat.model.Restaurant;
import com.nju.edu.njueat.repository.FoodRepository;
import com.nju.edu.njueat.repository.RestaurantRepository;
import com.nju.edu.njueat.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FoodServiceImpl implements FoodService {

    // 新品的获取数量
    private static int NEW_FOOD_VALUE = 10;

    // 每日推荐的数量
    private static int DAILY_RECOMMEND_VALUE = 10;

    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;


    @Override
    public void addNewFood(Food food) {

        foodRepository.save(food);
    }

    @Override
    public JSONArray getNewFoods() {
        List<Food> allFoods = foodRepository.getNewFoods();
        List<Food> newFoods = new ArrayList<>();

        // 得到发布日期最近10的菜品
        if (allFoods == null || allFoods.size() < NEW_FOOD_VALUE) {
            newFoods = allFoods;
        } else {
            newFoods = allFoods.subList(0, NEW_FOOD_VALUE);
        }
        return getFoodInfoByFoods(newFoods);

    }

    @Override
    public List<Food> getAllFoodsInCanteen(int restaurantId) {
        return foodRepository.getOneCanteenFoods(restaurantId);
    }

    @Override
    public JSONArray getDailyFood() {
        Random random = new Random(System.currentTimeMillis());
        List<Food> all = foodRepository.findAll();
        Map<Integer, Food> foodMap = new HashMap<>();
        while (foodMap.size() < DAILY_RECOMMEND_VALUE) {
            int randomIndex = random.nextInt(all.size());
            Food food = all.get(randomIndex);
            foodMap.put(food.getId(), food);
        }
        List<Food> dailyFoods = (List<Food>) foodMap.values();
        return getFoodInfoByFoods(dailyFoods);

    }


    /**
     * 根据获取到的菜品类定制返回消息格式
     *
     * @param foods 所有的菜品
     * @return 返回的消息
     */
    private JSONArray getFoodInfoByFoods(List<Food> foods) {
        // 获取相关的餐厅ID
        Map<Integer, Integer> restaurantIdAndIndexMap = new HashMap<>();
        for (Food eachFood : foods) {
            restaurantIdAndIndexMap.put(eachFood.getRestaurantId(), 1);
        }
        List<Integer> restaurantIds = new ArrayList<>(restaurantIdAndIndexMap.keySet());
        List<Restaurant> restaurantsInfo = restaurantRepository.findRestaurantsByIdIsIn(restaurantIds);
        Map<Integer, String> restaurantIdAndNameMap = new HashMap<>();
        restaurantsInfo.forEach(e -> {
            restaurantIdAndNameMap.put(e.getId(), e.getDescription());
        });

        // 定制消息内容
        JSONArray resultArray = new JSONArray();
        for (Food eachFood : foods) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("foodId", eachFood.getId());
            jsonObject.put("foodName", eachFood.getName());
            jsonObject.put("pictureUrl", eachFood.getPictureUrl());
            jsonObject.put("description", eachFood.getDescription());
            jsonObject.put("restaurantName", restaurantIdAndNameMap.get(eachFood.getRestaurantId()));
            jsonObject.put("window", eachFood.getWindow());
            jsonObject.put("price", eachFood.getPrice());
            jsonObject.put("launchDate", eachFood.getLaunchDate());
            resultArray.add(jsonObject);
        }
        return resultArray;
    }
}
