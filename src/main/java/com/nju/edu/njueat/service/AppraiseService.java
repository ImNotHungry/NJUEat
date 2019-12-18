package com.nju.edu.njueat.service;

import com.alibaba.fastjson.JSONArray;

public interface AppraiseService {
    /**
     * 添加评论
     * @param userId 用户id
     * @param comment 评论
     */
    void addComment(int userId, String comment);

    /**
     * 查看评论
     * @return 评论列表
     */
    JSONArray allComment();
}
