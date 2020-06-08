package com.argent.aiyunzan.HOME.mvp.model;

import android.app.Application;

import com.argent.aiyunzan.common.model.api.service.HomeService;
import com.argent.aiyunzan.common.model.bean.response.HomeMenu6XszyXqRsp;
import com.argent.aiyunzan.common.model.constant.ModelInfo;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.argent.aiyunzan.HOME.mvp.contract.Home_Menu6XqContract;

import io.reactivex.Observable;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 04/01/2020 17:29
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
public class Home_Menu6XqModel extends BaseModel implements Home_Menu6XqContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public Home_Menu6XqModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<HomeMenu6XszyXqRsp> loadData() {
        ModelInfo modelInfo = new ModelInfo();
        String article_id = modelInfo.getArticle_id();
        return mRepositoryManager.obtainRetrofitService(HomeService.class)
                .home_menu6XszyXq(article_id);
    }
}