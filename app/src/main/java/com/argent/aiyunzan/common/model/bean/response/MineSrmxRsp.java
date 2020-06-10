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
        private int werden;
        private int click;
        private int share;
        private int team;
        private String luck;
        private int other;

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

        public int getWerden() {
            return werden;
        }

        public void setWerden(int werden) {
            this.werden = werden;
        }

        public int getClick() {
            return click;
        }

        public void setClick(int click) {
            this.click = click;
        }

        public int getShare() {
            return share;
        }

        public void setShare(int share) {
            this.share = share;
        }

        public int getTeam() {
            return team;
        }

        public void setTeam(int team) {
            this.team = team;
        }

        public String getLuck() {
            return luck;
        }

        public void setLuck(String luck) {
            this.luck = luck;
        }

        public int getOther() {
            return other;
        }

        public void setOther(int other) {
            this.other = other;
        }
    }
}
