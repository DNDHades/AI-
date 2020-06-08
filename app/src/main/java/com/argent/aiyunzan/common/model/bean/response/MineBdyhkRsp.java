package com.argent.aiyunzan.common.model.bean.response;

import java.util.List;

/**
 * @author
 * @description:
 * @date :
 */
public class MineBdyhkRsp {
    /**
     * code : 200
     * msg : 发起请求成功!!
     * data : []
     */

    private int code;
    private String msg;
    private List<Datas> data;

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

    public List<Datas> getData() {
        return data;
    }

    public void setData(List<Datas> data) {
        this.data = data;
    }

    public static class Datas {

        private String card_name;
        private String card_number;
        private String username;
        private String mobile;

        public String getCard_name() {
            return card_name;
        }

        public void setCard_name(String card_name) {
            this.card_name = card_name;
        }

        public String getCard_number() {
            return card_number;
        }

        public void setCard_number(String card_number) {
            this.card_number = card_number;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
    }
}
