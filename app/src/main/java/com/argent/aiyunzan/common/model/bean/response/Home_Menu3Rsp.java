package com.argent.aiyunzan.common.model.bean.response;

/**
 * @author
 * @description:
 * @date :
 */
public class Home_Menu3Rsp {
    /**
     * code : 200
     * msg : 请求成功
     * data : {"imgs":"http://ai.lichao.fun/public/uploads/Qskrcode/20200401/545648504708488887code.jpg"}
     */

    private String code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * imgs : http://ai.lichao.fun/public/uploads/Qskrcode/20200401/545648504708488887code.jpg
         */

        private String imgs;

        public String getImgs() {
            return imgs;
        }

        public void setImgs(String imgs) {
            this.imgs = imgs;
        }
    }
}
