package com.nju.edu.njueat.service;

import com.nju.edu.njueat.model.Favorite;
import com.nju.edu.njueat.model.Food;
import com.nju.edu.njueat.repository.FavoriteRepository;

import java.util.List;

public interface UserService {

    List<Food> getCollectionFoods(int userId);

    void addNewCollection(Favorite favorite);

    void deleteCollection(Favorite favorite);
}
