package com.argent.aiyunzan.common.model.constant;

import com.argent.aiyunzan.common.model.constant.SPConstants;
import com.blankj.utilcode.util.SPUtils;

/**
 * @author
 * @description:
 * @date :
 */
public class ModelInfo {

    //uid
    public String getUid() {
        return SPUtils.getInstance().getString(SPConstants.UID);
    }

    //token
    public String getToken() {
        return SPUtils.getInstance().getString(SPConstants.TOKEN);
    }

    //isLoginIntercept
    public boolean getIsLoginIntercept() {
        return SPUtils.getInstance().getBoolean(SPConstants.ISLOGIN);
    }

    //客服跳转页面wx_number
    public String getWx_number() {
        return SPUtils.getInstance().getString(SPConstants.WXNUMBER);
    }

    //article_id
    public String getArticle_id() {
        return SPUtils.getInstance().getString(SPConstants.ARTICLE_ID);
    }

    //avatar
    public String getAvatar() {
        return SPUtils.getInstance().getString(SPConstants.AVATAR);
    }

    //nickname
    public String getNickname() {
        return SPUtils.getInstance().getString(SPConstants.NICKNAME);
    }

    //sex
    public String getSex() {
        return SPUtils.getInstance().getString(SPConstants.SEX);
    }

    //头像文件路径
    public String getTxFile() {
        return SPUtils.getInstance().getString(SPConstants.TXFILE);
    }

    //tdtype
    public String getTdType() {
        return SPUtils.getInstance().getString(SPConstants.TDTYPE);
    }

    //symxname
    public String getSymxname() {
        return SPUtils.getInstance().getString(SPConstants.SYMXNAME);
    }

    //money
    public String getMoney() {
        return SPUtils.getInstance().getString(SPConstants.MONEY);
    }

    //pass
    public String getPass() {
        return SPUtils.getInstance().getString(SPConstants.PASS);
    }

    //pass
    public String getType() {
        return SPUtils.getInstance().getString(SPConstants.TYPE);
    }

}
