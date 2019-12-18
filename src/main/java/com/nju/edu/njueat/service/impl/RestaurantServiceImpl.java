package com.nju.edu.njueat.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nju.edu.njueat.model.Restaurant;
import com.nju.edu.njueat.repository.AppraiseRepository;
import com.nju.edu.njueat.repository.RestaurantRepository;
import com.nju.edu.njueat.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
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
}
