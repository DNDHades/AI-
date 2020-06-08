package com.argent.aiyunzan.common.model.bean.response;

/**
 * @author
 * @description:
 * @date :
 */
public class LoginRegisterRsp {
    /**
     * code : 302
     * msg : 邀请码错误
     */

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
