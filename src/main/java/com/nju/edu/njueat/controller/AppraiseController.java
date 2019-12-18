package com.nju.edu.njueat.controller;

import com.nju.edu.njueat.common.response.ResultBody;
import com.nju.edu.njueat.common.response.ServiceStatusCode;
import com.nju.edu.njueat.service.AppraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appraise")
public class AppraiseController {

    private AppraiseService appraiseService;

    @Autowired
    public AppraiseController(AppraiseService appraiseService){
        this.appraiseService = appraiseService;
    }

    /**
     * 添加评论
     * @return 添加成功
     */
    @PostMapping("/addComment")
    public ResultBody addComment(@RequestParam("userId") int userId, @RequestParam("comment") String comment) {
        appraiseService.addComment(userId, comment);
        return new ResultBody(ServiceStatusCode.OK);
    }

    /**
     * 查看评论
     * @return 评论列表
     */
    @PostMapping("/viewComment")
    public ResultBody viewComment() {
        return new ResultBody(ServiceStatusCode.OK, appraiseService.allComment());
    }
}
