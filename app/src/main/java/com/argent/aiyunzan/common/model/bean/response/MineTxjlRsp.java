package com.argent.aiyunzan.common.model.bean.response;

import java.util.List;

/**
 * @author
 * @description:
 * @date :
 */
public class MineTxjlRsp {
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

            private String create_time;
            private String money;
            private String status;

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }
        }
    }
}
