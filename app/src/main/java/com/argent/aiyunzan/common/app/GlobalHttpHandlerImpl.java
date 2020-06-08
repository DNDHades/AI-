package com.argent.aiyunzan.common.app;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.argent.aiyunzan.MAIN.mvp.ui.activity.LoginActivity;
import com.argent.aiyunzan.MyApplication;
import com.argent.aiyunzan.common.model.api.Api;
import com.argent.aiyunzan.common.model.bean.info.EmptyInfo;
import com.argent.aiyunzan.common.model.bean.response.ErrorRps;
import com.argent.aiyunzan.common.model.bean.response.LoginGetCodeRsp;
import com.argent.aiyunzan.common.model.constant.EventBusTags;
import com.argent.aiyunzan.common.model.constant.ModelInfo;
import com.google.gson.Gson;
import com.jess.arms.http.GlobalHttpHandler;
import com.jess.arms.integration.EventBusManager;
import com.jess.arms.utils.ArmsUtils;

import org.simple.eventbus.EventBus;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * ================================================
 * 展示 {@link GlobalHttpHandler} 的用法
 * <p>
 * Created by MVPArmsTemplate on 12/10/2019 14:09
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public class GlobalHttpHandlerImpl implements GlobalHttpHandler {
    private Context context;

    public GlobalHttpHandlerImpl(Context context) {
        this.context = context;
    }

    /**
     * 这里可以先客户端一步拿到每一次 Http 请求的结果, 可以先解析成 Json, 再做一些操作, 如检测到 token 过期后
     * 重新请求 token, 并重新执行请求
     *
     * @param httpResult 服务器返回的结果 (已被框架自动转换为字符串)
     * @param chain      {@link okhttp3.Interceptor.Chain}
     * @param response   {@link Response}
     * @return
     */
    @Override
    public Response onHttpResultResponse(String httpResult, Interceptor.Chain chain, Response response) {
        /* 这里如果发现 token 过期, 可以先请求最新的 token, 然后在拿新的 token 放入 Request 里去重新请求
        注意在这个回调之前已经调用过 proceed(), 所以这里必须自己去建立网络请求, 如使用 Okhttp 使用新的 Request 去请求
        create a new request and modify it accordingly using the new token
        Request newRequest = chain.request().newBuilder().header("token", newToken)
                             .build();

        retry the request

        response.body().close();
        如果使用 Okhttp 将新的请求, 请求成功后, 再将 Okhttp 返回的 Response return 出去即可
        如果不需要返回新的结果, 则直接把参数 response 返回出去即可*/

        //结果监听
        try {
            ErrorRps errorRps = new Gson().fromJson(httpResult, ErrorRps.class);
            if (errorRps.getCode() == Api.ERROR) {
                EventBus.getDefault().post(errorRps, EventBusTags.ISLOADCODE999);
//                Intent intent = new Intent(context, LoginActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * 这里可以在请求服务器之前拿到 {@link Request}, 做一些操作比如给 {@link Request} 统一添加 token 或者 header 以及参数加密等操作
     *
     * @param chain   {@link okhttp3.Interceptor.Chain}
     * @param request {@link Request}
     * @return
     */
    @Override
    public Request onHttpRequestBefore(Interceptor.Chain chain, Request request) {
        /* 如果需要在请求服务器之前做一些操作, 则重新构建一个做过操作的 Request 并 return, 如增加 Header、Params 等请求信息, 不做操作则直接返回参数 request
        return chain.request().newBuilder().header("token", tokenId)
                              .build(); */
        //添加头
        ModelInfo modelInfo = new ModelInfo();
        if (modelInfo.getIsLoginIntercept()) {
            String time = System.currentTimeMillis() + "";
            return chain.request().newBuilder()
                    .addHeader("AUTHTOKEN", modelInfo.getToken() + "")
                    .addHeader("AUTHUID", modelInfo.getUid() + "")
                    .addHeader("TIME", time)
                    .addHeader("SIGN", ArmsUtils.encodeToMD5(
                            time +
                                    modelInfo.getUid() +
                                    modelInfo.getToken() +
                                    "AITechnologyLeader"))
                    .build();
        } else {
            return request;
        }

    }
}
