package com.nju.edu.njueat.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nju.edu.njueat.model.Appraise;
import com.nju.edu.njueat.repository.AppraiseRepository;
import com.nju.edu.njueat.service.AppraiseService;
import com.nju.edu.njueat.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppraiseServiceImpl implements AppraiseService {

    private AppraiseRepository appraiseRepository;

    @Autowired
    public AppraiseServiceImpl(AppraiseRepository appraiseRepository){
        this.appraiseRepository = appraiseRepository;
    }

    @Override
    public void addComment(int userId, String comment) {
        Appraise appraise = new Appraise();
        appraise.setUserId(userId);
        appraise.setComment(comment);
        appraise.setCommentTime(LocalDateTime.now());
        appraiseRepository.save(appraise);
    }

    @Override
    public JSONArray allComment() {
        List<Object[]> appraiseList = appraiseRepository.findAllAppraise();
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
