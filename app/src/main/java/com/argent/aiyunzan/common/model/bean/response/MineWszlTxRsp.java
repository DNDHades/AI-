package com.argent.aiyunzan.common.model.bean.response;

/**
 * @author
 * @description:
 * @date :
 */
public class MineWszlTxRsp {
    /**
     * code : 200
     * msg : 成功
     * data : {"id":11347,"path":"3532"}
     */

    private String code;
    private String msg;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
         * id : 11347
         * path : 3532
         */

        private int id;
        private String path;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }
}
