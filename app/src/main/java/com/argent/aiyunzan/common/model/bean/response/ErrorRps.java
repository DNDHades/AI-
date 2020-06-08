package com.argent.aiyunzan.common.model.bean.response;

/**
 * @author gxc
 * @description:
 * @date : 2020/4/24 14:06
 */
public class ErrorRps {
    /**
     * code : 999
     * msg : 你的账号已在其它设备登录，被迫下线！！
     */

    private int code;
    private String msg;

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
