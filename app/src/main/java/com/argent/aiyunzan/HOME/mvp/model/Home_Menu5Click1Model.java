package com.argent.aiyunzan.HOME.mvp.model;

import android.app.Application;

import com.argent.aiyunzan.common.model.api.service.HomeService;
import com.argent.aiyunzan.common.model.bean.response.HomeMenu5Kfzx1Rsp;
import com.argent.aiyunzan.common.model.bean.response.HomeMenu5Kfzx2Rsp;
import com.argent.aiyunzan.common.model.constant.ModelInfo;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.argent.aiyunzan.HOME.mvp.contract.Home_Menu5Click1Contract;

import io.reactivex.Observable;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 09:10
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
public class Home_Menu5Click1Model extends BaseModel implements Home_Menu5Click1Contract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public Home_Menu5Click1Model(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<HomeMenu5Kfzx2Rsp> loadKfzx2Data() {
        ModelInfo modelInfo = new ModelInfo();
        String wx_number = modelInfo.getWx_number();
        return mRepositoryManager.obtainRetrofitService(HomeService.class)
                .home_menu5Kfzx2(wx_number + "");
    }
}