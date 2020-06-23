package com.argent.aiyunzan.common.model.bean.response;

/**
 * @author
 * @description:
 * @date :
 */
public class MineSrmxRsp {
    /**
     * code : 200
     * msg : 数据获取成功!!
     * data : {"myprofit":0,"all_profit":0,"werden":0,"click":0,"share":0,"team":0,"luck":0,"other":0}
     * time : 2020.04.02
     */

    private int code;
    private String msg;
    private DataBean data;
    private String time;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public static class DataBean {
        /**
         * myprofit : 0
         * all_profit : 0
         * werden : 0
         * click : 0
         * share : 0
         * team : 0
         * luck : 0
         * other : 0
         */

        private String myprofit;
        private String all_profit;
        private String werden;
        private String click;
        private String share;
        private String team;
        private String luck;
        private String other;

        public String getMyprofit() {
            return myprofit;
        }

        public void setMyprofit(String myprofit) {
            this.myprofit = myprofit;
        }

        public String getAll_profit() {
            return all_profit;
        }

        public void setAll_profit(String all_profit) {
            this.all_profit = all_profit;
        }

        public String getWerden() {
            return werden;
        }

        public void setWerden(String werden) {
            this.werden = werden;
        }

        public String getClick() {
            return click;
        }

        public void setClick(String click) {
            this.click = click;
        }

        public String getShare() {
            return share;
        }

        public void setShare(String share) {
            this.share = share;
        }

        public String getTeam() {
            return team;
        }

        public void setTeam(String team) {
            this.team = team;
        }

        public String getLuck() {
            return luck;
        }

        public void setLuck(String luck) {
            this.luck = luck;
        }

        public String getOther() {
            return other;
        }

        public void setOther(String other) {
            this.other = other;
        }
    }
}
