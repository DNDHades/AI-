package com.argent.aiyunzan.common.model.bean.response;

/**
 * @author
 * @description:
 * @date :
 */
public class Mine_WszlHqRsp {
    /**
     * code : 200
     * msg : 数据获取成功!!
     * data : {"avatar":"741","uid":88887,"mobile":"18683728343","sex":1,"nickname":"云赞","avatars":"http://ai.lichao.fun/public/uploads/images/20190813/b005ee81da9712f912527c830540a511.jpg"}
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
         * avatar : 741
         * uid : 88887
         * mobile : 18683728343
         * sex : 1
         * nickname : 云赞
         * avatars : http://ai.lichao.fun/public/uploads/images/20190813/b005ee81da9712f912527c830540a511.jpg
         */

        private String avatar;
        private int uid;
        private String mobile;
        private int sex;
        private String nickname;
        private String avatars;

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getAvatars() {
            return avatars;
        }

        public void setAvatars(String avatars) {
            this.avatars = avatars;
        }
    }
}
