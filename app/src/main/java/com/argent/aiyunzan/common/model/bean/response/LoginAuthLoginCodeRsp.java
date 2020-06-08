package com.argent.aiyunzan.common.model.bean.response;

/**
 * @author
 * @description:
 * @date :
 */
public class LoginAuthLoginCodeRsp {
    /**
     * code : 200
     * msg : 登录成功!!
     * data : {"uid":88887,"token":"NL40094LLFJBH3OORN8JEFDKG5D"}
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
         * uid : 88887
         * token : NL40094LLFJBH3OORN8JEFDKG5D
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
