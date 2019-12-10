package com.nju.edu.njueat.service.impl;

import com.nju.edu.njueat.model.Favorite;
import com.nju.edu.njueat.model.Food;
import com.nju.edu.njueat.repository.FavoriteRepository;
import com.nju.edu.njueat.repository.FoodRepository;
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

    @Override
    public List<Food> getCollectionFoods(int userId) {
        List<Food> foods = new ArrayList<>();
        List<Favorite> favorites = favoriteRepository.getAllByUserId(userId);
        for (Favorite favor : favorites) {
            foods.add(foodRepository.getOne(favor.getFoodId()));
        }
        return foods;
    }

    @Override
    public void addNewCollection(Favorite favorite) {
        favoriteRepository.save(favorite);
    }

    @Override
    public void deleteCollection(Favorite favorite) {
        favoriteRepository.delete(favorite);
    }
}
