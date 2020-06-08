package com.argent.aiyunzan.common.model.bean.response;

/**
 * @author
 * @description:
 * @date :
 */
public class MineMenu6BbgxRsp {

    /**
     * code : 200
     * msg : 数据请求成功!!!
     * data : {"ios_url":"https://dw.pub/FtMa","ios_number":"1.0.1","android_url":"http://www.ailingxiu66.com/ai_app/ai_release2019-09-25.apk","android_number":"1.0.1"}
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
         * ios_url : https://dw.pub/FtMa
         * ios_number : 1.0.1
         * android_url : http://www.ailingxiu66.com/ai_app/ai_release2019-09-25.apk
         * android_number : 1.0.1
         */

        private String ios_url;
        private String ios_number;
        private String android_url;
        private String android_number;

        public String getIos_url() {
            return ios_url;
        }

        public void setIos_url(String ios_url) {
            this.ios_url = ios_url;
        }

        public String getIos_number() {
            return ios_number;
        }

        public void setIos_number(String ios_number) {
            this.ios_number = ios_number;
        }

        public String getAndroid_url() {
            return android_url;
        }

        public void setAndroid_url(String android_url) {
            this.android_url = android_url;
        }

        public String getAndroid_number() {
            return android_number;
        }

        public void setAndroid_number(String android_number) {
            this.android_number = android_number;
        }
    }
}
