package com.argent.aiyunzan.HOME.mvp.model;

import android.app.Application;

import com.argent.aiyunzan.common.model.api.service.HomeService;
import com.argent.aiyunzan.common.model.bean.response.HomeMenu4BuyWxRsp;
import com.argent.aiyunzan.common.model.bean.response.HomeMenu4BuyZfbRsp;
import com.argent.aiyunzan.common.model.bean.response.Home_Menu4HqxtjeRps;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.argent.aiyunzan.HOME.mvp.contract.Home_Menu4Contract;

import io.reactivex.Observable;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/30/2020 19:31
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
public class Home_Menu4Model extends BaseModel implements Home_Menu4Contract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public Home_Menu4Model(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<Home_Menu4HqxtjeRps> loadHqxtjeData() {
        return mRepositoryManager.obtainRetrofitService(HomeService.class)
                .home_menu4Hqxtje("");
    }

    @Override
    public Observable<HomeMenu4BuyWxRsp> loadDataBuyWx(String member) {
        return mRepositoryManager.obtainRetrofitService(HomeService.class)
                .home_menu4BuyWx(member);
    }

    @Override
    public Observable<HomeMenu4BuyZfbRsp> loadDataBuyZfb(String member) {
        return mRepositoryManager.obtainRetrofitService(HomeService.class)
                .home_menu4BuyZfb(member);
    }
}