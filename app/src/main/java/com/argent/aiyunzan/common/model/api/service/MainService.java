package com.argent.aiyunzan.common.model.api.service;

import com.argent.aiyunzan.common.model.api.Api;
import com.argent.aiyunzan.common.model.bean.response.LoginAuthLoginCodeRsp;
import com.argent.aiyunzan.common.model.bean.response.LoginForgetRsp;
import com.argent.aiyunzan.common.model.bean.response.LoginGetCodeRsp;
import com.argent.aiyunzan.common.model.bean.response.LoginRegisterRsp;
import com.argent.aiyunzan.common.model.bean.response.LoginRsp;


import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * @author
 * @description:
 * @date :
 */
public interface MainService {
    //注册
    @FormUrlEncoded
    @POST(Api.MAIN_REGISTER)
    Observable<LoginRegisterRsp> main_register(@Field("mobile") String mobile,
                                               @Field("verifi") String verifi,
                                               @Field("password") String password,
                                               @Field("secret") String secret,
                                               @Field("code") String code);

    //获取手机短信验证码接口
    @FormUrlEncoded
    @POST(Api.MAIN_GETCODE)
    Observable<LoginGetCodeRsp> main_getCode(@Field("mobile") String mobile);

    //登陆
    @FormUrlEncoded
    @POST(Api.MAIN_LOGIN)
    Observable<LoginRsp> main_login(@Field("mobile") String mobile,
                                    @Field("password") String et_pwd);

    //找回登录密码
    @FormUrlEncoded
    @POST(Api.MAIN_LOGINFORGETACTIVITY)
    Observable<LoginForgetRsp> main_loadConfirm(@Field("verifi") String verifi,
                                                @Field("mobile") String mobile,
                                                @Field("pass") String pass,
                                                @Field("password") String password);

    //验证码登陆
    @FormUrlEncoded
    @POST(Api.MAIN_AUTHLOGINCODE)
    Observable<LoginAuthLoginCodeRsp> main_loadAuthLoginCode(@Field("mobile") String mobile,
                                                             @Field("verifi") String verifi);

}
