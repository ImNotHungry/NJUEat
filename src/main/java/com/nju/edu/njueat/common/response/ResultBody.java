package com.nju.edu.njueat.common.response;

public class ResultBody {
    //响应结果，成功为success, 失败为error
    private String result;
    //状态码
    private int code;
    //提示给用户的信息
    private String msg;
    //结果对象
    private Object object;

    /**
     * @param state 错误原因
     */
    public ResultBody(ServiceStatusCode state) {
        this.code = state.getCode();
        this.msg = state.getMsg();
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
        this.code = state.getCode();
        this.msg = state.getMsg();
        this.object = object;
        if (state.equals(ServiceStatusCode.OK)) {
            result = "success";
        } else {
            result = "error";
        }
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
