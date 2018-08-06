package com.facts.result;

/**
 * 返回结果
 * @author Administrator
 */
public class Result {

    /**
     * 返回参数
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回结果
     */
    private Object object;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
