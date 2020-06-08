package com.argent.aiyunzan.MINE.mvp.model;

import android.app.Application;

import com.argent.aiyunzan.common.model.api.service.MineService;
import com.argent.aiyunzan.common.model.bean.response.MineSrmxRsp;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.argent.aiyunzan.MINE.mvp.contract.Mine_SrmxContract;

import io.reactivex.Observable;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 17:00
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
public class Mine_SrmxModel extends BaseModel implements Mine_SrmxContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public Mine_SrmxModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<MineSrmxRsp> loadData() {
        return mRepositoryManager.obtainRetrofitService(MineService.class)
                .load_Srmx("");
    }
}