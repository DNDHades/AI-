package com.argent.aiyunzan.common.model.bean.response;

/**
 * @author gxc
 * @description:
 * @date : 2020/5/22 13:08
 */
public class HomeMenu4BuyWxRsp {
    /**
     * code : 200
     * msg : OK
     * data : {"return_code":"SUCCESS","return_msg":"OK","appid":"wx23c65c04736df633","mch_id":"1587543871","nonce_str":"Lk548NREku3323Hk","sign":"B72C9037B12F478192969462B94521E9","result_code":"SUCCESS","prepay_id":"wx221307552594915920e0c4891330267300","trade_type":"MWEB","mweb_url":"https://wx.tenpay.com/cgi-bin/mmpayweb-bin/checkmweb?prepay_id=wx221307552594915920e0c4891330267300&package=3082435847&redirect_url=www.yunz99.com%3A%2F%2Fhttp%3A%2F%2Fwww.yunz99.com%2Fpublic%2Findex.php%2Fdm%2FWxnotify%2Fcallback%3Forder_sn%3DWX88887202005229848495271659"}
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
         * return_code : SUCCESS
         * return_msg : OK
         * appid : wx23c65c04736df633
         * mch_id : 1587543871
         * nonce_str : Lk548NREku3323Hk
         * sign : B72C9037B12F478192969462B94521E9
         * result_code : SUCCESS
         * prepay_id : wx221307552594915920e0c4891330267300
         * trade_type : MWEB
         * mweb_url : https://wx.tenpay.com/cgi-bin/mmpayweb-bin/checkmweb?prepay_id=wx221307552594915920e0c4891330267300&package=3082435847&redirect_url=www.yunz99.com%3A%2F%2Fhttp%3A%2F%2Fwww.yunz99.com%2Fpublic%2Findex.php%2Fdm%2FWxnotify%2Fcallback%3Forder_sn%3DWX88887202005229848495271659
         */

        private String return_code;
        private String return_msg;
        private String appid;
        private String mch_id;
        private String nonce_str;
        private String sign;
        private String result_code;
        private String prepay_id;
        private String trade_type;
        private String mweb_url;

        public String getReturn_code() {
            return return_code;
        }

        public void setReturn_code(String return_code) {
            this.return_code = return_code;
        }

        public String getReturn_msg() {
            return return_msg;
        }

        public void setReturn_msg(String return_msg) {
            this.return_msg = return_msg;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getMch_id() {
            return mch_id;
        }

        public void setMch_id(String mch_id) {
            this.mch_id = mch_id;
        }

        public String getNonce_str() {
            return nonce_str;
        }

        public void setNonce_str(String nonce_str) {
            this.nonce_str = nonce_str;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getResult_code() {
            return result_code;
        }

        public void setResult_code(String result_code) {
            this.result_code = result_code;
        }

        public String getPrepay_id() {
            return prepay_id;
        }

        public void setPrepay_id(String prepay_id) {
            this.prepay_id = prepay_id;
        }

        public String getTrade_type() {
            return trade_type;
        }

        public void setTrade_type(String trade_type) {
            this.trade_type = trade_type;
        }

        public String getMweb_url() {
            return mweb_url;
        }

        public void setMweb_url(String mweb_url) {
            this.mweb_url = mweb_url;
        }
    }
}
