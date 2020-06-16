package com.argent.aiyunzan.common.model.bean.response;

import java.util.List;

/**
 * @author
 * @description:
 * @date :
 */
public class HomeRsp {
    /**
     * code : 200
     * msg : 数据获取成功!!
     * data : {"picarr":["http://ai.lichao.fun/public/uploads/images/20190807/70a2cf548f40ab64ec8a18e4a5c6b614.png","http://ai.lichao.fun/public/uploads/images/20190807/70a2cf548f40ab64ec8a18e4a5c6b614.png","http://ai.lichao.fun/public/uploads/images/20190807/70a2cf548f40ab64ec8a18e4a5c6b614.png"],"note":"因其他支付方式正在维护中！现在新用户只能通过微信支付购买！感谢大家配合！我们一直在努力！","array":[{"member":66705,"num":6},{"member":66674,"num":6},{"member":66671,"num":6},{"member":66694,"num":1},{"member":66702,"num":10},{"member":66713,"num":6},{"member":66706,"num":3},{"member":66668,"num":5},{"member":66712,"num":5},{"member":66698,"num":6},{"member":66690,"num":8},{"member":66704,"num":7},{"member":66710,"num":4},{"member":66695,"num":2},{"member":66682,"num":2},{"member":66703,"num":6},{"member":66670,"num":10},{"member":66685,"num":4},{"member":66683,"num":3},{"member":66691,"num":7},{"member":66696,"num":10},{"member":66666,"num":8},{"member":66673,"num":3},{"member":66711,"num":9},{"member":66680,"num":2},{"member":66679,"num":9},{"member":66697,"num":9},{"member":66707,"num":6},{"member":66699,"num":5},{"member":66692,"num":2},{"member":66684,"num":2},{"member":66693,"num":4},{"member":66687,"num":2},{"member":66688,"num":10},{"member":66681,"num":4},{"member":66665,"num":6},{"member":66675,"num":7},{"member":66714,"num":1},{"member":66700,"num":2},{"member":66676,"num":9},{"member":66677,"num":2},{"member":66701,"num":5},{"member":66689,"num":6},{"member":66667,"num":5},{"member":66678,"num":9},{"member":66686,"num":5},{"member":66669,"num":4},{"member":66708,"num":7},{"member":66672,"num":5},{"member":66709,"num":1}]}
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
         * picarr : ["http://ai.lichao.fun/public/uploads/images/20190807/70a2cf548f40ab64ec8a18e4a5c6b614.png","http://ai.lichao.fun/public/uploads/images/20190807/70a2cf548f40ab64ec8a18e4a5c6b614.png","http://ai.lichao.fun/public/uploads/images/20190807/70a2cf548f40ab64ec8a18e4a5c6b614.png"]
         * note : 因其他支付方式正在维护中！现在新用户只能通过微信支付购买！感谢大家配合！我们一直在努力！
         * array : [{"member":66705,"num":6},{"member":66674,"num":6},{"member":66671,"num":6},{"member":66694,"num":1},{"member":66702,"num":10},{"member":66713,"num":6},{"member":66706,"num":3},{"member":66668,"num":5},{"member":66712,"num":5},{"member":66698,"num":6},{"member":66690,"num":8},{"member":66704,"num":7},{"member":66710,"num":4},{"member":66695,"num":2},{"member":66682,"num":2},{"member":66703,"num":6},{"member":66670,"num":10},{"member":66685,"num":4},{"member":66683,"num":3},{"member":66691,"num":7},{"member":66696,"num":10},{"member":66666,"num":8},{"member":66673,"num":3},{"member":66711,"num":9},{"member":66680,"num":2},{"member":66679,"num":9},{"member":66697,"num":9},{"member":66707,"num":6},{"member":66699,"num":5},{"member":66692,"num":2},{"member":66684,"num":2},{"member":66693,"num":4},{"member":66687,"num":2},{"member":66688,"num":10},{"member":66681,"num":4},{"member":66665,"num":6},{"member":66675,"num":7},{"member":66714,"num":1},{"member":66700,"num":2},{"member":66676,"num":9},{"member":66677,"num":2},{"member":66701,"num":5},{"member":66689,"num":6},{"member":66667,"num":5},{"member":66678,"num":9},{"member":66686,"num":5},{"member":66669,"num":4},{"member":66708,"num":7},{"member":66672,"num":5},{"member":66709,"num":1}]
         */

        private String note;

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        private String level;
        private List<String> picarr;
        private List<ArrayBean> array;

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public List<String> getPicarr() {
            return picarr;
        }

        public void setPicarr(List<String> picarr) {
            this.picarr = picarr;
        }

        public List<ArrayBean> getArray() {
            return array;
        }

        public void setArray(List<ArrayBean> array) {
            this.array = array;
        }

        public static class ArrayBean {
            /**
             * member : 66705
             * num : 6
             */

            private int member;
            private int num;

            public int getMember() {
                return member;
            }

            public void setMember(int member) {
                this.member = member;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }
        }
    }
}
