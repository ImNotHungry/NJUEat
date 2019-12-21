package com.nju.edu.njueat.service;

import com.alibaba.fastjson.JSONArray;
import com.nju.edu.njueat.model.Favorite;
import com.nju.edu.njueat.model.Food;
import com.nju.edu.njueat.model.User;

import java.util.List;

public interface UserService {

    JSONArray getCollectionFoods(int userId);

    void addNewCollection(int userId, int foodId);

    void deleteCollection(int userId, int foodId);

    User getUserByWechatId(String wxId);

    void addUserByWechatId(String wxId,String userName, String avatarUrl);
}
