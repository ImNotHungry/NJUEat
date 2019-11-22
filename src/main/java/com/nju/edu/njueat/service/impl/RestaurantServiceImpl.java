package com.nju.edu.njueat.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nju.edu.njueat.model.Appraise;
import com.nju.edu.njueat.model.Restaurant;
import com.nju.edu.njueat.repository.AppraiseRepository;
import com.nju.edu.njueat.repository.RestaurantRepository;
import com.nju.edu.njueat.service.RestaurantService;
import com.nju.edu.njueat.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private RestaurantRepository restaurantRepository;

    private AppraiseRepository appraiseRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, AppraiseRepository appraiseRepository){
        this.restaurantRepository = restaurantRepository;
        this.appraiseRepository = appraiseRepository;
    }

    @Override
    public JSONArray allCanteen() {
        List<Restaurant> restaurantList = restaurantRepository.findAllByIsCanteen(true);
        JSONArray array = new JSONArray();
        for (Restaurant restaurant : restaurantList){
            JSONObject object = new JSONObject();
            object.put("restaurantName", restaurant.getName());
            object.put("pictureUrl", restaurant.getPictureUrl());
            object.put("serviceTime", restaurant.getServiceTime());
            array.add(object);
        }
        return array;
    }

    @Override
    public JSONArray outsideRestaurant() {
        List<Restaurant> restaurantList = restaurantRepository.findAllByIsCanteen(false);
        JSONArray array = new JSONArray();
        for (Restaurant restaurant : restaurantList){
            if(array.size()>10){
                break;
            }
            JSONObject object = new JSONObject();
            object.put("restaurantName", restaurant.getName());
            object.put("restaurantAddress", restaurant.getAddress());
            object.put("pictureUrl", restaurant.getPictureUrl());
            object.put("description", restaurant.getDescription());
            object.put("consumption", restaurant.getConsumption());
            array.add(object);
        }
        return array;
    }

    @Override
    public void addComment(int userId, int restaurantId, String comment) {
        Appraise appraise = new Appraise();
        appraise.setUserId(userId);
        appraise.setRestaurantId(restaurantId);
        appraise.setComment(comment);
        appraise.setCommentTime(LocalDateTime.now());
        appraiseRepository.save(appraise);
    }

    @Override
    public JSONArray allComment(int restaurantId) {
        List<Object[]> appraiseList = appraiseRepository.findAllByRestaurantId(restaurantId);
        JSONArray array = new JSONArray();
        for (Object[] appraise : appraiseList){
            JSONObject object = new JSONObject();
            object.put("username", appraise[0]);
            object.put("avatarUrl", appraise[1]);
            object.put("comment", appraise[2]);
            object.put("commentTime", DateUtil.dateToStr((LocalDateTime) appraise[3]));
            array.add(object);
        }
        return array;
    }
}
