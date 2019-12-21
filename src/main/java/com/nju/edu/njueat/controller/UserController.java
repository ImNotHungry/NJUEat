package com.nju.edu.njueat.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nju.edu.njueat.common.response.ResultBody;
import com.nju.edu.njueat.common.response.ServiceStatusCode;
import com.nju.edu.njueat.service.UserService;
import com.nju.edu.njueat.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResultBody login() {
        return new ResultBody(ServiceStatusCode.OK);
    }

    @PostMapping("/addCollection")
    public ResultBody addNewFavor(@RequestParam("userId") int userId,
                                  @RequestParam("foodId") int foodId) {
        userService.addNewCollection(userId, foodId);
        return new ResultBody(ServiceStatusCode.OK);
    }

    @PostMapping("/deleteCollection")
    public ResultBody deleteFavor(@RequestParam("userId") int userId,
                                  @RequestParam("foodId") int foodId) {
        userService.deleteCollection(userId, foodId);
        return new ResultBody(ServiceStatusCode.OK);
    }

    @PostMapping("/viewCollection")
    public ResultBody getAllFavors(@RequestParam("userId") int userId) {
        return new ResultBody(ServiceStatusCode.OK, userService.getCollectionFoods(userId));
    }

    @PostMapping("/getUserInfo")
    public ResultBody getUser(@RequestParam("wxId") String wxId) {
        return new ResultBody(ServiceStatusCode.OK, userService.getUserByWechatId(wxId));
    }

    @PostMapping("/addUser")
    public ResultBody addUser(@RequestParam("wxID") String wxId,
                              @RequestParam("userName") String userName,
                              @RequestParam("avatarUrl") String avatarUrl) {
        userService.addUserByWechatId(wxId, userName, avatarUrl);
        return new ResultBody(ServiceStatusCode.OK);
    }

    @PostMapping("/getOpenId")
    public ResultBody getOpenId(@RequestParam("code") String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx446f60adbe0ec659&secret=5538daa8ab5638348494ff25129d862a&js_code=" + code + "&grant_type=authorization_code";
        JSONObject jsonObject = JSON.parseObject(HttpUtil.doGet(url));
        return new ResultBody(ServiceStatusCode.OK, jsonObject);
    }
}
