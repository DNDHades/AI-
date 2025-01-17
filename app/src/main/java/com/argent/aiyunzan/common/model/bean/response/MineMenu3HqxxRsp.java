package com.argent.aiyunzan.common.model.bean.response;

/**
 * @author
 * @description:
 * @date :
 */
public class MineMenu3HqxxRsp {
    /**
     * code : 200
     * msg : 发起请求成功!!
     * data : {"card_name":"中国银行","card_number":"6217007200043528366","username":"李超","mobile":"13410843464"}
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
         * card_name : 中国银行
         * card_number : 6217007200043528366
         * username : 李超
         * mobile : 13410843464
         */

        private String card_name;
        private String card_number;
        private String username;
        private String alipay_accunt;

        public String getUser_info_id_no() {
            return user_info_id_no;
        }

        public void setUser_info_id_no(String user_info_id_no) {
            this.user_info_id_no = user_info_id_no;
        }

        private String user_info_id_no;

        public String getCard_name() {
            return card_name;
        }

        public void setCard_name(String card_name) {
            this.card_name = card_name;
        }

        public String getCard_number() {
            return card_number;
        }

        public void setCard_number(String card_number) {
            this.card_number = card_number;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAlipay_accunt() {
            return alipay_accunt;
        }

        public void setAlipay_accunt(String mobile) {
            this.alipay_accunt = mobile;
        }
    }
}
