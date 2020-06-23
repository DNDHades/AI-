package com.argent.aiyunzan.common.model.bean.response;

/**
 * @author
 * @description:
 * @date :
 */
public class Home_Menu4HqxtjeRps {
    /**
     * code : 200
     * msg : 数据获取成功!!
     * data : {"price":128,"cost_price":288,"machine_max":10,"level":0,"use_num":10,"info_id":0}
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
         * price : 128
         * cost_price : 288
         * machine_max : 10
         * level : 0
         * use_num : 10
         * info_id : 0
         */

        private int price;
        private int cost_price;
        private int machine_max;
        private int level;
        private int use_num;
        private int info_id;

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getCost_price() {
            return cost_price;
        }

        public void setCost_price(int cost_price) {
            this.cost_price = cost_price;
        }

        public int getMachine_max() {
            return machine_max;
        }

        public void setMachine_max(int machine_max) {
            this.machine_max = machine_max;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getUse_num() {
            return use_num;
        }

        public void setUse_num(int use_num) {
            this.use_num = use_num;
        }

        public int getInfo_id() {
            return info_id;
        }

        public void setInfo_id(int info_id) {
            this.info_id = info_id;
        }
    }
}
