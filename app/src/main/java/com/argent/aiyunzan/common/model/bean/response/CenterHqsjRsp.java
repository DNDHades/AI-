package com.argent.aiyunzan.common.model.bean.response;

/**
 * @author
 * @description:
 * @date :
 */
public class CenterHqsjRsp {
    /**
     * code : 200
     * msg : 获取数据成功！!
     * data : {"level":0,"click_num":0,"money":0,"status":0}
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
         * level : 0
         * click_num : 0
         * money : 0
         * status : 0
         */

        private int level;
        private int click_num;
        private int money;
        private int status;

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getClick_num() {
            return click_num;
        }

        public void setClick_num(int click_num) {
            this.click_num = click_num;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
