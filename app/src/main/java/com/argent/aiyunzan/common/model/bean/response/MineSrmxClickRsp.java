package com.argent.aiyunzan.common.model.bean.response;

import java.util.List;

/**
 * @author
 * @description:
 * @date :
 */
public class MineSrmxClickRsp {
    /**
     * code : 200
     * msg : 数据获取成功!!
     * data : {"list":[],"count":0}
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
         * list : []
         * count : 0
         */

        private int count;
        private List<Datas> list;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<Datas> getList() {
            return list;
        }

        public void setList(List<Datas> list) {
            this.list = list;
        }

        public static class Datas {

            private double money;
            private String time;
            private String types;

            public double getMoney() {
                return money;
            }

            public void setMoney(double money) {
                this.money = money;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getTypes() {
                return types;
            }

            public void setTypes(String types) {
                this.types = types;
            }
        }
    }
}
