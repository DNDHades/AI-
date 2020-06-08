package com.argent.aiyunzan.common.model.bean.response;

/**
 * @author
 * @description:
 * @date :
 */
public class HomeMenu5Kfzx2Rsp {
    /**
     * code : 200
     * msg : 数据获取成功!!
     * data : {"wxewm":"http://ai.lichao.fun/public/uploads/images/20191002/367653c5fab445233a220d156d48d407.jpg","wxnumber":"请联系QQ客服！"}
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
         * wxewm : http://ai.lichao.fun/public/uploads/images/20191002/367653c5fab445233a220d156d48d407.jpg
         * wxnumber : 请联系QQ客服！
         */

        private String wxewm;
        private String wxnumber;

        public String getWxewm() {
            return wxewm;
        }

        public void setWxewm(String wxewm) {
            this.wxewm = wxewm;
        }

        public String getWxnumber() {
            return wxnumber;
        }

        public void setWxnumber(String wxnumber) {
            this.wxnumber = wxnumber;
        }
    }
}
