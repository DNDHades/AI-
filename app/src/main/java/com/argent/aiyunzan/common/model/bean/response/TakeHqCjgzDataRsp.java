package com.argent.aiyunzan.common.model.bean.response;

/**
 * @author
 * @description:
 * @date :
 */
public class TakeHqCjgzDataRsp {
    /**
     * code : 200
     * msg : 获取规则成功！！
     * data : {"share_num":5,"share_time":"2020-07-25 00:0"}
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
         * share_num : 5
         * share_time : 2020-07-25 00:0
         */

        private int share_num;
        private String share_time;

        public int getShare_num() {
            return share_num;
        }

        public void setShare_num(int share_num) {
            this.share_num = share_num;
        }

        public String getShare_time() {
            return share_time;
        }

        public void setShare_time(String share_time) {
            this.share_time = share_time;
        }
    }
}
