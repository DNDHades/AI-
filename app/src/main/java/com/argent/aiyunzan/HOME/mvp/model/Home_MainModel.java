package com.argent.aiyunzan.HOME.mvp.model;

import android.app.Application;

import com.argent.aiyunzan.common.model.api.service.HomeService;
import com.argent.aiyunzan.common.model.bean.response.HomeRsp;
import com.argent.aiyunzan.common.model.bean.response.LoginForgetRsp;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.FragmentScope;

import javax.inject.Inject;

import com.argent.aiyunzan.HOME.mvp.contract.Home_MainContract;

import io.reactivex.Observable;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/30/2020 15:10
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
public class Home_MainModel extends BaseModel implements Home_MainContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public Home_MainModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<HomeRsp> loadHome() {
        return mRepositoryManager.obtainRetrofitService(HomeService.class)
                .home("");
    }
}