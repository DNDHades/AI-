package com.argent.aiyunzan.AICENTER.mvp.model;

import android.app.Application;

import com.argent.aiyunzan.common.model.api.service.CenterService;
import com.argent.aiyunzan.common.model.api.service.HomeService;
import com.argent.aiyunzan.common.model.bean.response.CenterHqsjRsp;
import com.argent.aiyunzan.common.model.bean.response.CenterStartRsp;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.FragmentScope;

import javax.inject.Inject;

import com.argent.aiyunzan.AICENTER.mvp.contract.Center_MainContract;

import io.reactivex.Observable;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 10:23
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
public class Center_MainModel extends BaseModel implements Center_MainContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public Center_MainModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<CenterHqsjRsp> loadData() {
        return mRepositoryManager.obtainRetrofitService(CenterService.class)
                .center_Data("");
    }

    @Override
    public Observable<CenterStartRsp> loadStart() {
        return mRepositoryManager.obtainRetrofitService(CenterService.class)
                .center_Strat("");
    }
}