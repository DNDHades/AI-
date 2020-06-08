package com.argent.aiyunzan.common.model.bean.response;

/**
 * @author
 * @description:
 * @date :
 */
public class HomeMenu5Kfzx1Rsp {
    /**
     * code : 200
     * msg : 数据获取成功!!
     * data : {"qqone":"3293639760","qqtwo":"3429439776","wxone":"请联系QQ客服！","wxtwo":"请联系QQ客服！","kefu_time":"09:30-12:00     14:00-20:30","ios_number":"1.0.1","android_number":"1.0.1"}
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
         * qqone : 3293639760
         * qqtwo : 3429439776
         * wxone : 请联系QQ客服！
         * wxtwo : 请联系QQ客服！
         * kefu_time : 09:30-12:00     14:00-20:30
         * ios_number : 1.0.1
         * android_number : 1.0.1
         */

        private String qqone;
        private String qqtwo;
        private String wxone;
        private String wxtwo;
        private String kefu_time;
        private String ios_number;
        private String android_number;
        private String vip_team_service_qq;
        private String vip_team_service_wechat;

        public String getVip_team_service_qq() {
            return vip_team_service_qq;
        }

        public void setVip_team_service_qq(String vip_team_service_qq) {
            this.vip_team_service_qq = vip_team_service_qq;
        }

        public String getVip_team_service_wechat() {
            return vip_team_service_wechat;
        }

        public void setVip_team_service_wechat(String vip_team_service_wechat) {
            this.vip_team_service_wechat = vip_team_service_wechat;
        }

        public String getQqone() {
            return qqone;
        }

        public void setQqone(String qqone) {
            this.qqone = qqone;
        }

        public String getQqtwo() {
            return qqtwo;
        }

        public void setQqtwo(String qqtwo) {
            this.qqtwo = qqtwo;
        }

        public String getWxone() {
            return wxone;
        }

        public void setWxone(String wxone) {
            this.wxone = wxone;
        }

        public String getWxtwo() {
            return wxtwo;
        }

        public void setWxtwo(String wxtwo) {
            this.wxtwo = wxtwo;
        }

        public String getKefu_time() {
            return kefu_time;
        }

        public void setKefu_time(String kefu_time) {
            this.kefu_time = kefu_time;
        }

        public String getIos_number() {
            return ios_number;
        }

        public void setIos_number(String ios_number) {
            this.ios_number = ios_number;
        }

        public String getAndroid_number() {
            return android_number;
        }

        public void setAndroid_number(String android_number) {
            this.android_number = android_number;
        }
    }
}
