package com.nju.edu.njueat.common.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 请求时返回的结果状态
 */
public enum ServiceStatusCode implements Serializable {
    //成功
    OK(1, "成功");

    //状态码
    private int code;
    //提示给用户的信息
    private String msg;

    ServiceStatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
