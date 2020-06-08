package com.argent.aiyunzan.MINE.mvp.model;

import android.app.Application;

import com.argent.aiyunzan.common.model.api.service.HomeService;
import com.argent.aiyunzan.common.model.api.service.MineService;
import com.argent.aiyunzan.common.model.bean.response.HomeMenu5Kfzx1Rsp;
import com.argent.aiyunzan.common.model.bean.response.MineMenu6BbgxRsp;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.argent.aiyunzan.MINE.mvp.contract.Mine_Menu6Contract;

import io.reactivex.Observable;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 16:16
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
public class Mine_Menu6Model extends BaseModel implements Mine_Menu6Contract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public Mine_Menu6Model(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<HomeMenu5Kfzx1Rsp> loadKfzx1Data() {
        return mRepositoryManager.obtainRetrofitService(HomeService.class)
                .home_menu5Kfzx1("");
    }

    @Override
    public Observable<MineMenu6BbgxRsp> loadClick() {
        return mRepositoryManager.obtainRetrofitService(MineService.class)
                .load_Bbgx("");
    }
}