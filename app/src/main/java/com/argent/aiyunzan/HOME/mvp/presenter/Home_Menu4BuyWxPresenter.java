package com.argent.aiyunzan.HOME.mvp.presenter;

import android.app.Application;

import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;

import javax.inject.Inject;

import com.argent.aiyunzan.HOME.mvp.contract.Home_Menu4BuyWxContract;


/**
 * ================================================
 * Date: 05/22/2020 13:13
 * Description:
 * ================================================
 */
@ActivityScope
public class Home_Menu4BuyWxPresenter extends BasePresenter<Home_Menu4BuyWxContract.Model, Home_Menu4BuyWxContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public Home_Menu4BuyWxPresenter(Home_Menu4BuyWxContract.Model model, Home_Menu4BuyWxContract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }
}
