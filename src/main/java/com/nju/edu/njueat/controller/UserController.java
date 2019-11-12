package com.nju.edu.njueat.controller;

import com.nju.edu.njueat.common.response.ResultBody;
import com.nju.edu.njueat.common.response.ServiceStatusCode;
import com.nju.edu.njueat.model.User;
import com.nju.edu.njueat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResultBody login(){
        return new ResultBody(ServiceStatusCode.OK);
    }
}
