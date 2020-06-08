package com.argent.aiyunzan.common.model.bean.response;

import java.util.List;

/**
 * @author
 * @description:
 * @date :
 */
public class HomeMenu6XszyRsp {
    /**
     * code : 200
     * msg : 数据获取成功!!
     * data : [{"article_id":32,"title":"1、AI云赞是什么？"},{"article_id":11,"title":"2、如何购买这套系统？"},{"article_id":33,"title":"3、购买成功后怎么操作？"},{"article_id":34,"title":"4、如何分享给好友？"},{"article_id":35,"title":"5、AI云赞APP购买之后如何赚到钱？每天收益有多少？分享给好友我有什么好处？"},{"article_id":36,"title":"6、怎么提现？提现提到哪里？多久能到账？"},{"article_id":37,"title":"7、提现时绑定银行卡写错了，提现取款密码忘记了怎么办？"},{"article_id":38,"title":"8、什么时候抽奖？抽奖中了奖之后怎么提现？"},{"article_id":39,"title":"9、买了第一套之后，再多买几套当天就有收益吗？"},{"article_id":40,"title":"10、AI云赞智能系统使用期限是多久？"},{"article_id":41,"title":"11、为什么平台还需要我们来做？"},{"article_id":42,"title":"12、平台赢利点有哪些？"},{"article_id":43,"title":"13、如何自己建团队推广AI云赞APP?"},{"article_id":44,"title":"14、这套智能点赞关注系统主要用于哪些短视频平台？"},{"article_id":45,"title":"15、这个平台适合哪些人做？"}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * article_id : 32
         * title : 1、AI云赞是什么？
         */

        private int article_id;
        private String title;

        public int getArticle_id() {
            return article_id;
        }

        public void setArticle_id(int article_id) {
            this.article_id = article_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
