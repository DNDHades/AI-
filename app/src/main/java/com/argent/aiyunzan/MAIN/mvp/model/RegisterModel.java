package com.argent.aiyunzan.MAIN.mvp.model;

import android.app.Application;

import com.argent.aiyunzan.common.model.api.service.MainService;
import com.argent.aiyunzan.common.model.bean.response.LoginGetCodeRsp;
import com.argent.aiyunzan.common.model.bean.response.LoginRegisterRsp;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.argent.aiyunzan.MAIN.mvp.contract.RegisterContract;

import io.reactivex.Observable;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/30/2020 14:13
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
public class RegisterModel extends BaseModel implements RegisterContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public RegisterModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<LoginRegisterRsp> loadRegister(String et_mobile, String et_verifi,
                                                     String et_password, String et_secret,
                                                     String et_code) {
        return mRepositoryManager.obtainRetrofitService(MainService.class)
                .main_register(et_mobile, et_verifi, et_password, et_secret, et_code);
    }

    @Override
    public Observable<LoginGetCodeRsp> loadGetCode(String et_mobile) {
        return mRepositoryManager.obtainRetrofitService(MainService.class)
                .main_getCode(et_mobile);
    }
}