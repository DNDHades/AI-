package com.argent.aiyunzan.common.model.api.service;

import com.argent.aiyunzan.common.model.api.Api;
import com.argent.aiyunzan.common.model.bean.response.CenterHqsjRsp;
import com.argent.aiyunzan.common.model.bean.response.CenterStartRsp;
import com.argent.aiyunzan.common.model.bean.response.MineMenu2HqsjRsp;
import com.argent.aiyunzan.common.model.bean.response.MineMenu2TjRsp;
import com.argent.aiyunzan.common.model.bean.response.MineMenu3BdyhkPostDataRsp;
import com.argent.aiyunzan.common.model.bean.response.MineMenu3HqxxRsp;
import com.argent.aiyunzan.common.model.bean.response.MineMenu4PostDataRsp;
import com.argent.aiyunzan.common.model.bean.response.MineMenu6BbgxRsp;
import com.argent.aiyunzan.common.model.bean.response.MineSrmxClickRsp;
import com.argent.aiyunzan.common.model.bean.response.MineSrmxRsp;
import com.argent.aiyunzan.common.model.bean.response.MineSyRsp;
import com.argent.aiyunzan.common.model.bean.response.MineTdxqRsp;
import com.argent.aiyunzan.common.model.bean.response.MineTxjlRsp;
import com.argent.aiyunzan.common.model.bean.response.MineWdtdRsp;
import com.argent.aiyunzan.common.model.bean.response.MineWszlSaveRsp;
import com.argent.aiyunzan.common.model.bean.response.MineWszlTxRsp;
import com.argent.aiyunzan.common.model.bean.response.Mine_WszlHqRsp;

import java.io.File;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * @author
 * @description:
 * @date :
 */
public interface MineService {

    //个人中心-首页接口
    @FormUrlEncoded
    @POST(Api.MINE_DATA)
    Observable<MineSyRsp> load_Data(@Field("") String empty);

    //个人中心-我的团队
    @FormUrlEncoded
    @POST(Api.MINE_WDTD)
    Observable<MineWdtdRsp> load_Wdtd(@Field("") String empty);

    //个人中心-我的团队详细接口
    @FormUrlEncoded
    @POST(Api.MINE_TDXQ)
    Observable<MineTdxqRsp> load_WdtdXq(@Field("type") String type,
                                        @Field("page") String page);

    //个人中心-完善资料(获得用户原始数据)
    @FormUrlEncoded
    @POST(Api.MINE_WSZLHQ)
    Observable<Mine_WszlHqRsp> load_WszlHq(@Field("") String empty);

//    //个人中心-完善资料(提交数据)
//    @FormUrlEncoded
//    @POST(Api.MINE_WSZLBC)
//    Observable<MineWszlSaveRsp> load_WszlBc(@Field("avatar") String avatar,
//                                            @Field("nickname") String nickname,
//                                            @Field("sex") String sex);

    //个人中心-完善资料(提交数据)
    @POST(Api.MINE_WSZLBC)
    Observable<MineWszlSaveRsp> load_WszlBc(@Body MultipartBody multipartBody);

    @Multipart
    @POST(Api.MINE_TX)
    Observable<MineWszlTxRsp> load_Tx(@Part MultipartBody.Part file);

    //个人中心-收益明细接口
    @FormUrlEncoded
    @POST(Api.MINE_SRMX)
    Observable<MineSrmxRsp> load_Srmx(@Field("") String empty);

    //个人中心-收益明细详情接口
    @FormUrlEncoded
    @POST(Api.MINE_SRMXCLICK)
    Observable<MineSrmxClickRsp> load_SrmxClick(@Field("type") String type,
                                                @Field("page") String page);

    //个人中心-提现记录接口
    @FormUrlEncoded
    @POST(Api.MINE_TXJL)
    Observable<MineTxjlRsp> load_Txjl(@Field("page") String page);

    //个人中心-判断是否设置过提现密码及绑定过银行卡返回银行卡绑定信息
    @FormUrlEncoded
    @POST(Api.MINE_YHKXX)
    Observable<MineMenu3HqxxRsp> load_Hqyhkxx(@Field("") String empty);

    //个人中心-绑定银行卡-提交数据
    @FormUrlEncoded
    @POST(Api.MINE_BDYHKTJ)
    Observable<MineMenu3BdyhkPostDataRsp> load_Bdyhktj(@Field("username") String et_username,
                                                       @Field("card_name") String et_card_name,
                                                       @Field("card_number") String et_card_number,
                                                       @Field("mobile") String et_mobile,
                                                       @Field("verifi") String et_verifi,
                                                       @Field("pass") String et_pass);

    //个人中心-修改提现密码
    @FormUrlEncoded
    @POST(Api.MINE_TXGM)
    Observable<MineMenu4PostDataRsp> load_Txgm(@Field("mobile") String mobile,
                                               @Field("verifi") String verifi,
                                               @Field("newpass") String newpass,
                                               @Field("pass") String pass);

    //个人中心-我要提现-获取提现数据接口
    @FormUrlEncoded
    @POST(Api.MINE_WYTXHQSJ)
    Observable<MineMenu2HqsjRsp> load_WytxHqsj(@Field("") String empty);

    //个人中心-我要提现-提现提交接口
    @FormUrlEncoded
    @POST(Api.MINE_WYTXTJ)
    Observable<MineMenu2TjRsp> load_WytxTj(@Field("money") String money,
                                           @Field("pass") String pass);

    //个人中心-版本更新-获取下载地址和版本号接口
    @FormUrlEncoded
    @POST(Api.MINE_BBGX)
    Observable<MineMenu6BbgxRsp> load_Bbgx(@Field("") String empty);
}
