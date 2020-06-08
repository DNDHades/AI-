package com.argent.aiyunzan.common.model.bean.response;

/**
 * @author
 * @description:
 * @date :
 */
public class HomeMenu6XszyXqRsp {
    /**
     * code : 200
     * msg : 数据获取成功!!
     * data : {"title":"1、AI云赞是什么？","text":"<p><span style=\";font-family:宋体;font-size:14px\">AI<span style=\"font-family:宋体\">云赞<\/span><span style=\"font-family:Calibri\">=AI(<\/span><span style=\"font-family:宋体\">人工智能<\/span><span style=\"font-family:Calibri\">)+5G<\/span><span style=\"font-family:宋体\">网络<\/span><span style=\"font-family:Calibri\">+<\/span><span style=\"font-family:宋体\">短视频<\/span><span style=\"font-family:Calibri\">+IP<\/span><span style=\"font-family:宋体\">链接自动识别<\/span><\/span><\/p><p><span style=\";font-family:宋体;font-size:14px\">AI<span style=\"font-family:宋体\">云赞是以人工智能为基础，<\/span><span style=\"font-family:Calibri\">5G<\/span><span style=\"font-family:宋体\">网络的速度，在短视频热潮的风口上，通过<\/span><span style=\"font-family:Calibri\">IP<\/span><span style=\"font-family:宋体\">链接自动识别环境下研发出的一款全新短视频自动点赞<\/span><span style=\"font-family:Calibri\">+<\/span><span style=\"font-family:宋体\">关注的智能系统。主要以抓取流量和粉丝变现而获得巨大的商业价值。<\/span><\/span><\/p><p><br/><\/p>"}
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
         * title : 1、AI云赞是什么？
         * text : <p><span style=";font-family:宋体;font-size:14px">AI<span style="font-family:宋体">云赞</span><span style="font-family:Calibri">=AI(</span><span style="font-family:宋体">人工智能</span><span style="font-family:Calibri">)+5G</span><span style="font-family:宋体">网络</span><span style="font-family:Calibri">+</span><span style="font-family:宋体">短视频</span><span style="font-family:Calibri">+IP</span><span style="font-family:宋体">链接自动识别</span></span></p><p><span style=";font-family:宋体;font-size:14px">AI<span style="font-family:宋体">云赞是以人工智能为基础，</span><span style="font-family:Calibri">5G</span><span style="font-family:宋体">网络的速度，在短视频热潮的风口上，通过</span><span style="font-family:Calibri">IP</span><span style="font-family:宋体">链接自动识别环境下研发出的一款全新短视频自动点赞</span><span style="font-family:Calibri">+</span><span style="font-family:宋体">关注的智能系统。主要以抓取流量和粉丝变现而获得巨大的商业价值。</span></span></p><p><br/></p>
         */

        private String title;
        private String text;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
