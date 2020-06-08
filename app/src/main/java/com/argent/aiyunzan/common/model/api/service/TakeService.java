package com.argent.aiyunzan.common.model.api.service;

import com.argent.aiyunzan.common.model.api.Api;
import com.argent.aiyunzan.common.model.bean.response.CenterHqsjRsp;
import com.argent.aiyunzan.common.model.bean.response.CenterStartRsp;
import com.argent.aiyunzan.common.model.bean.response.TakeHqCjgzDataRsp;
import com.argent.aiyunzan.common.model.bean.response.TakeStartRsp;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author
 * @description:
 * @date :
 */
public interface TakeService {

    //点赞中心-获取数据
    @FormUrlEncoded
    @POST(Api.TAKE_DATA)
    Observable<TakeHqCjgzDataRsp> take_Data(@Field("") String empty);

    //点赞中心-点击轮盘开始抽奖
    @FormUrlEncoded
    @POST(Api.TAKE_START)
    Observable<TakeStartRsp> take_Start(@Field("") String empty);

}
