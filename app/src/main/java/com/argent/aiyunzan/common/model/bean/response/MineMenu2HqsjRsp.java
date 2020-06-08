package com.argent.aiyunzan.common.model.bean.response;

/**
 * @author
 * @description:
 * @date :
 */
public class MineMenu2HqsjRsp {

    /**
     * code : 200
     * msg : 请求数据成功!!
     * data : {"werden_min":50,"such_time":"10:00-16:30","werden_feel":5,"bankcard":0,"change":"92.80"}
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
         * werden_min : 50
         * such_time : 10:00-16:30
         * werden_feel : 5
         * bankcard : 0
         * change : 92.80
         */

        private int werden_min;
        private String such_time;
        private int werden_feel;
        private int bankcard;
        private String change;

        public int getWerden_min() {
            return werden_min;
        }

        public void setWerden_min(int werden_min) {
            this.werden_min = werden_min;
        }

        public String getSuch_time() {
            return such_time;
        }

        public void setSuch_time(String such_time) {
            this.such_time = such_time;
        }

        public int getWerden_feel() {
            return werden_feel;
        }

        public void setWerden_feel(int werden_feel) {
            this.werden_feel = werden_feel;
        }

        public int getBankcard() {
            return bankcard;
        }

        public void setBankcard(int bankcard) {
            this.bankcard = bankcard;
        }

        public String getChange() {
            return change;
        }

        public void setChange(String change) {
            this.change = change;
        }
    }
}
