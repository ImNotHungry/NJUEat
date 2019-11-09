package com.nju.edu.njueat.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultBody {
    //响应结果，成功为success, 失败为error
    private String result;
    //响应状态
    private ServiceStatusCode state;
    //结果对象
    private Object object;

    /**
     * @param state 错误原因
     */
    public ResultBody(ServiceStatusCode state) {
        this.state = state;
        if (state.equals(ServiceStatusCode.OK)) {
            result = "success";
        } else {
            result = "error";
        }
    }

    /**
     * @param state 错误原因
     * @param object 响应结果
     */
    public ResultBody(ServiceStatusCode state, Object object) {
        this.state = state;
        this.object = object;
        if (state.equals(ServiceStatusCode.OK)) {
            result = "success";
        } else {
            result = "error";
        }
    }
}
