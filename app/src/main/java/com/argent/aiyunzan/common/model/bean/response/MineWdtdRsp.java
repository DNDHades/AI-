package com.argent.aiyunzan.common.model.bean.response;

/**
 * @author
 * @description:
 * @date :
 */
public class MineWdtdRsp {
    /**
     * code : 200
     * msg : 数据获取成功!!
     * data : {"onelevel":0,"twolevel":0}
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
         * onelevel : 0
         * twolevel : 0
         */

        private int onelevel;
        private int twolevel;

        public int getOnelevel() {
            return onelevel;
        }

        public void setOnelevel(int onelevel) {
            this.onelevel = onelevel;
        }

        public int getTwolevel() {
            return twolevel;
        }

        public void setTwolevel(int twolevel) {
            this.twolevel = twolevel;
        }
    }
}
