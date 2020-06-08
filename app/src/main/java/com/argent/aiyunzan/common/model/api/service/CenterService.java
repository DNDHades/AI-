package com.argent.aiyunzan.common.model.api.service;

import com.argent.aiyunzan.common.model.api.Api;
import com.argent.aiyunzan.common.model.bean.response.CenterHqsjRsp;
import com.argent.aiyunzan.common.model.bean.response.CenterStartRsp;
import com.argent.aiyunzan.common.model.bean.response.HomeMenu6XszyRsp;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author
 * @description:
 * @date :
 */
public interface CenterService {

    //点赞中心-获取数据
    @FormUrlEncoded
    @POST(Api.CENTER_DATA)
    Observable<CenterHqsjRsp> center_Data(@Field("") String empty);

    //点赞中心-点击开启机器人自动点赞接口
    @FormUrlEncoded
    @POST(Api.CENTER_START)
    Observable<CenterStartRsp> center_Strat(@Field("") String empty);
}
