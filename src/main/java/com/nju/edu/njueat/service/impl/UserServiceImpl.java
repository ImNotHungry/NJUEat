package com.nju.edu.njueat.service.impl;

import com.nju.edu.njueat.model.Favorite;
import com.nju.edu.njueat.model.Food;
import com.nju.edu.njueat.model.User;
import com.nju.edu.njueat.repository.FavoriteRepository;
import com.nju.edu.njueat.repository.FoodRepository;
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
    private UserRepository userRepository;

    @Override
    public List<Food> getCollectionFoods(int userId) {
        List<Food> foods = new ArrayList<>();
        List<Favorite> favorites = favoriteRepository.getAllByUserId(userId);
        for (Favorite favor : favorites) {
            foods.add(foodRepository.getById(favor.getFoodId()));
        }

        return foods;
    }

    @Override
    public void addNewCollection(Favorite favorite) {
        favoriteRepository.save(favorite);
    }

    @Override
    public void deleteCollection(int userId, int foodId, int restaurantId) {
        Favorite favorite = favoriteRepository.getFavoriteByUserIdAndFoodIdAndRestaurantId(userId, foodId, restaurantId);
        favoriteRepository.delete(favorite);
    }

    @Override
    public User getUserByWechatId(String wxId) {
        return userRepository.getByWechatId(wxId);
    }

    @Override
    public void addUserByWechatId(String wxId, String userName) {
        User user = userRepository.getByWechatId(wxId);
        if (user != null) {
            return;
        } else {
            User newUser = new User();
            newUser.setName(userName);
            newUser.setWechatId(wxId);
            newUser.setAvatarUrl("");
            newUser.setPassword("");
            userRepository.save(newUser);
        }
    }


}
