package com.argent.aiyunzan.HOME.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.argent.aiyunzan.HOME.mvp.contract.Home_Menu4BuyWxContract;


/**
 * ================================================
 * Date: 05/22/2020 13:13
 * Description:
 * ================================================
 */
@ActivityScope
public class Home_Menu4BuyWxModel extends BaseModel implements Home_Menu4BuyWxContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public Home_Menu4BuyWxModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }
}