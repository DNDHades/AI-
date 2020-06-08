package com.argent.aiyunzan.common.model.api.service;

import com.argent.aiyunzan.common.model.api.Api;
import com.argent.aiyunzan.common.model.bean.response.HomeMenu4BuyWxRsp;
import com.argent.aiyunzan.common.model.bean.response.HomeMenu4BuyZfbRsp;
import com.argent.aiyunzan.common.model.bean.response.HomeMenu5Kfzx1Rsp;
import com.argent.aiyunzan.common.model.bean.response.HomeMenu5Kfzx2Rsp;
import com.argent.aiyunzan.common.model.bean.response.HomeMenu6XszyRsp;
import com.argent.aiyunzan.common.model.bean.response.HomeMenu6XszyXqRsp;
import com.argent.aiyunzan.common.model.bean.response.HomeRsp;
import com.argent.aiyunzan.common.model.bean.response.Home_Menu3Rsp;
import com.argent.aiyunzan.common.model.bean.response.Home_Menu4HqxtjeRps;
import com.argent.aiyunzan.common.model.bean.response.LoginAuthLoginCodeRsp;
import com.argent.aiyunzan.common.model.bean.response.LoginForgetRsp;
import com.argent.aiyunzan.common.model.bean.response.LoginRegisterRsp;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @author
 * @description:
 * @date :
 */
public interface HomeService {

    //首页
    @FormUrlEncoded
    @POST(Api.HOME)
    Observable<HomeRsp> home(@Field("") String nul);

    //验证码登陆
    @FormUrlEncoded
    @POST(Api.HOME_MENU3)
    Observable<Home_Menu3Rsp> home_menu3(@Field("") String empty);


    //立即购买获取系统金额及限购数量
    @FormUrlEncoded
    @POST(Api.HOME_MENU4HQXTJE)
    Observable<Home_Menu4HqxtjeRps> home_menu4Hqxtje(@Field("") String empty);

    //立即购买-微信支付接口
    @FormUrlEncoded
    @POST(Api.HOME_MENU4BUYWX)
    Observable<HomeMenu4BuyWxRsp> home_menu4BuyWx(@Field("member") String member);

    //立即购买-支付宝支付接口
    @FormUrlEncoded
    @POST(Api.HOME_MENU4BUYZFB)
    Observable<HomeMenu4BuyZfbRsp> home_menu4BuyZfb(@Field("member") String member);

    //客服中心接口
    @FormUrlEncoded
    @POST(Api.HOME_MENU5KFZX1)
    Observable<HomeMenu5Kfzx1Rsp> home_menu5Kfzx1(@Field("") String empty);

    //客服中心2接口
    @FormUrlEncoded
    @POST(Api.HOME_MENU5KFZX2)
    Observable<HomeMenu5Kfzx2Rsp> home_menu5Kfzx2(@Field("wx_number") String wx_number);

    //新手指引接口
    @FormUrlEncoded
    @POST(Api.HOME_MENU6XSZY)
    Observable<HomeMenu6XszyRsp> home_menu6Xszy(@Field("") String empty);

    //新手指引接口
    @FormUrlEncoded
    @POST(Api.HOME_MENU6XSZYXQ)
    Observable<HomeMenu6XszyXqRsp> home_menu6XszyXq(@Field("article_id") String article_id);
}
