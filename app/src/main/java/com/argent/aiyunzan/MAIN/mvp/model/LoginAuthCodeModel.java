package com.argent.aiyunzan.MAIN.mvp.model;

import android.app.Application;

import com.argent.aiyunzan.common.model.api.service.MainService;
import com.argent.aiyunzan.common.model.bean.response.LoginAuthLoginCodeRsp;
import com.argent.aiyunzan.common.model.bean.response.LoginGetCodeRsp;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.argent.aiyunzan.MAIN.mvp.contract.LoginAuthCodeContract;

import io.reactivex.Observable;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/30/2020 14:24
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
public class LoginAuthCodeModel extends BaseModel implements LoginAuthCodeContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public LoginAuthCodeModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }


    @Override
    public Observable<LoginGetCodeRsp> loadGetCode(String et_mobile) {
        return mRepositoryManager.obtainRetrofitService(MainService.class)
                .main_getCode(et_mobile);
    }

    @Override
    public Observable<LoginAuthLoginCodeRsp> loadAuthLoginCode(String et_mobile, String et_verifi) {
        return mRepositoryManager.obtainRetrofitService(MainService.class)
                .main_loadAuthLoginCode(et_mobile,et_verifi);
    }
}