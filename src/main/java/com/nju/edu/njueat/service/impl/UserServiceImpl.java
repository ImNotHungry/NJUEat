package com.nju.edu.njueat.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nju.edu.njueat.model.Favorite;
import com.nju.edu.njueat.model.Food;
import com.nju.edu.njueat.model.User;
import com.nju.edu.njueat.repository.FavoriteRepository;
import com.nju.edu.njueat.repository.FoodRepository;
import com.nju.edu.njueat.repository.RestaurantRepository;
import com.nju.edu.njueat.repository.UserRepository;
import com.nju.edu.njueat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public JSONArray getCollectionFoods(int userId) {
        JSONArray array = new JSONArray();
        List<Food> foods = new ArrayList<>();
        List<Favorite> favorites = favoriteRepository.getAllByUserId(userId);
        for (Favorite favor : favorites) {
            foods.add(foodRepository.getById(favor.getFoodId()));
        }
        for (Food food :foods) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",food.getId());
            jsonObject.put("name",food.getName());
            jsonObject.put("description",food.getDescription());
            jsonObject.put("pictureUrl",food.getPictureUrl());
            jsonObject.put("price",food.getPrice());
            jsonObject.put("restaurantName",restaurantRepository.getById(food.getRestaurantId()).getName());
            jsonObject.put("window",food.getWindow());
            jsonObject.put("restaurantId",food.getRestaurantId());
            array.add(jsonObject);
        }
        return array;
    }

    @Override
    public void addNewCollection(int userId, int foodId) {
        Favorite favorite = new Favorite();
        Food food = foodRepository.getById(foodId);
        favorite.setUserId(userId);
        favorite.setFoodId(foodId);
        favorite.setRestaurantId(food.getRestaurantId());
        favoriteRepository.save(favorite);
    }

    @Override
    public void deleteCollection(int userId, int foodId) {
        Favorite favorite = favoriteRepository.getFavoriteByUserIdAndFoodId(userId, foodId);
        favoriteRepository.delete(favorite);
    }

    @Override
    public User getUserByWechatId(String wxId) {
        return userRepository.getByWechatId(wxId);
    }

    @Override
    public void addUserByWechatId(String wxId, String userName, String avatarUrl) {
        User user = userRepository.getByWechatId(wxId);
        if (user != null) {
            return;
        } else {
            User newUser = new User();
            newUser.setName(userName);
            newUser.setWechatId(wxId);
            newUser.setAvatarUrl(avatarUrl);
            newUser.setPassword("");
            userRepository.save(newUser);
        }
    }


}
