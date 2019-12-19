package com.nju.edu.njueat.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nju.edu.njueat.model.Favorite;
import com.nju.edu.njueat.model.Food;
import com.nju.edu.njueat.model.Restaurant;
import com.nju.edu.njueat.repository.FavoriteRepository;
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
    @Autowired
    private FavoriteRepository favoriteRepository;


    @Override
    public void addNewFood(Food food) {

        foodRepository.save(food);
    }

    @Override
    public JSONArray getNewFoods(int userId) {
        List<Food> allFoods = foodRepository.getNewFoods();
        List<Food> newFoods = new ArrayList<>();

        // 得到发布日期最近10的菜品
        if (allFoods == null || allFoods.size() < NEW_FOOD_VALUE) {
            newFoods = allFoods;
        } else {
            newFoods = allFoods.subList(0, NEW_FOOD_VALUE);
        }
        return getFoodInfoByFoods(newFoods, userId);

    }

    @Override
    public JSONArray getAllFoodsInCanteen(int restaurantId, int userId) {
        List<Food> oneCanteenFoods = foodRepository.getOneCanteenFoods(restaurantId);
        return getFoodInfoByFoods(oneCanteenFoods, userId);
    }

    @Override
    public JSONArray getDailyFood(int userId) {
        Random random = new Random(System.currentTimeMillis());
        List<Food> all = foodRepository.findAll();
        Map<Integer, Food> foodMap = new HashMap<>();
        int step = 0;
        while (step < DAILY_RECOMMEND_VALUE) {
            int randomIndex = random.nextInt(all.size());
            Food food = all.get(randomIndex);
            foodMap.put(food.getId(), food);
            step++;
        }
        List<Food> dailyFoods = new ArrayList<>();
        for (int eachId : foodMap.keySet()) {
            dailyFoods.add(foodMap.get(eachId));
        }
        return getFoodInfoByFoods(dailyFoods, userId);

    }


    /**
     * 根据获取到的菜品类定制返回消息格式
     *
     * @param foods  所有的菜品
     * @param userId userId
     * @return 返回的消息
     */
    private JSONArray getFoodInfoByFoods(List<Food> foods, int userId) {
        List<Favorite> allFavoriteByUserId = favoriteRepository.getAllByUserId(userId);
        List<Integer> favoriteFoodIds = new ArrayList<>();
        allFavoriteByUserId.forEach(e -> {
            favoriteFoodIds.add(e.getFoodId());
        });

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
            jsonObject.put("CanteenId", eachFood.getRestaurantId());
            jsonObject.put("restaurantId", eachFood.getRestaurantId());
            jsonObject.put("window", eachFood.getWindow());
            jsonObject.put("price", eachFood.getPrice());
            jsonObject.put("launchDate", eachFood.getLaunchDate());
            if (favoriteFoodIds.indexOf(eachFood.getId()) > -1) {
                jsonObject.put("isFavor", true);
            } else {
                jsonObject.put("isFavor", false);
            }
            resultArray.add(jsonObject);
        }
        return resultArray;
    }
}
