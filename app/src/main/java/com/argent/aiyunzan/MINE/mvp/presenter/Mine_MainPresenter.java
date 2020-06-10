package com.argent.aiyunzan.MINE.mvp.presenter;

import android.app.Application;
import android.util.Log;

import com.argent.aiyunzan.common.model.api.Api;
import com.argent.aiyunzan.common.model.bean.response.CenterHqsjRsp;
import com.argent.aiyunzan.common.model.bean.response.MineSyRsp;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;

import javax.inject.Inject;

import com.argent.aiyunzan.MINE.mvp.contract.Mine_MainContract;
import com.jess.arms.utils.RxLifecycleUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 13:36
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
public class Mine_MainPresenter extends BasePresenter<Mine_MainContract.Model, Mine_MainContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public Mine_MainPresenter(Mine_MainContract.Model model, Mine_MainContract.View rootView) {
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

    public void loadData() {
        mModel.loadData()
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(0, 2))//遇到错误时重试,第一个参数为重试几次,第二个参数为重试的间隔
                .doOnSubscribe(disposable -> {
                    mRootView.showLoading();//显示下拉刷新的进度条
                }).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> {
                    mRootView.hideLoading();//隐藏下拉刷新的进度条
                })
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用 Rxlifecycle,使 Disposable 和 Activity 一起销毁
                .subscribe(new ErrorHandleSubscriber<MineSyRsp>(mErrorHandler) {
                    @Override
                    public void onNext(MineSyRsp data) {
                        if (data.getCode() == Api.SUCCESS) {
                            mRootView.loadHomeSuccess(data);
                        }
                    }
                });
    }
}
