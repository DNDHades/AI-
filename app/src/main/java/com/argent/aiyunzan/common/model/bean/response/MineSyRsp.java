package com.argent.aiyunzan.common.model.bean.response;

/**
 * @author
 * @description:
 * @date :
 */
public class MineSyRsp {
    /**
     * code : 200
     * msg : 数据获取成功!!
     * data : {"nickname":"43444444","uid":88887,"mobile":"18683728343","fid":88885,"avatar":"http://www.yunz99.com/public/uploads/images/20200403/20200403/d962 eb3cba2b5e2d2f792a379a2f2d12.jpg","change":"92.80","level":1,"all_shou":3,"day_shou":3,"werden":0}
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
         * nickname : 43444444
         * uid : 88887
         * mobile : 18683728343
         * fid : 88885
         * avatar : http://www.yunz99.com/public/uploads/images/20200403/20200403/d962 eb3cba2b5e2d2f792a379a2f2d12.jpg
         * change : 92.80
         * level : 1
         * all_shou : 3
         * day_shou : 3
         * werden : 0
         */

        private String nickname;
        private String uid;
        private String mobile;
        private String fid;
        private String avatar;
        private String change;
        private String level;
        private String all_shou;
        private String day_shou;
        private String werden;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getFid() {
            return fid;
        }

        public void setFid(String fid) {
            this.fid = fid;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getChange() {
            return change;
        }

        public void setChange(String change) {
            this.change = change;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getAll_shou() {
            return all_shou;
        }

        public void setAll_shou(String all_shou) {
            this.all_shou = all_shou;
        }

        public String getDay_shou() {
            return day_shou;
        }

        public void setDay_shou(String day_shou) {
            this.day_shou = day_shou;
        }

        public String getWerden() {
            return werden;
        }

        public void setWerden(String werden) {
            this.werden = werden;
        }
    }
}
