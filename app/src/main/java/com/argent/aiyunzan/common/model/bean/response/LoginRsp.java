package com.argent.aiyunzan.common.model.bean.response;

/**
 * @author
 * @description:
 * @date :
 */
public class LoginRsp {
    /**
     * code : 200
     * msg : 登录成功!!
     * data : {"uid":88886,"token":"93ONDLR68F5IDCI767OHRJNFCIP"}
     */

    private int code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * uid : 88886
         * token : 93ONDLR68F5IDCI767OHRJNFCIP
         */

        private int uid;
        private String token;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
