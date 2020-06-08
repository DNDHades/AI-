package com.argent.aiyunzan.MINE.mvp.presenter;

import android.app.Application;
import android.util.Log;

import com.argent.aiyunzan.common.model.api.Api;
import com.argent.aiyunzan.common.model.bean.response.MineSyRsp;
import com.argent.aiyunzan.common.model.bean.response.MineWszlSaveRsp;
import com.argent.aiyunzan.common.model.bean.response.MineWszlTxRsp;
import com.argent.aiyunzan.common.model.bean.response.Mine_WszlHqRsp;
import com.argent.aiyunzan.common.model.constant.ModelInfo;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;

import javax.inject.Inject;

import com.argent.aiyunzan.MINE.mvp.contract.Mine_WszlContract;
import com.jess.arms.utils.ArmsUtils;
import com.jess.arms.utils.RxLifecycleUtils;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 14:32
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
public class Mine_WszlPresenter extends BasePresenter<Mine_WszlContract.Model, Mine_WszlContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public Mine_WszlPresenter(Mine_WszlContract.Model model, Mine_WszlContract.View rootView) {
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
                .retryWhen(new RetryWithDelay(3, 2))//遇到错误时重试,第一个参数为重试几次,第二个参数为重试的间隔
                .doOnSubscribe(disposable -> {
                    mRootView.showLoading();//显示下拉刷新的进度条
                }).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> {
                    mRootView.hideLoading();//隐藏下拉刷新的进度条
                })
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用 Rxlifecycle,使 Disposable 和 Activity 一起销毁
                .subscribe(new ErrorHandleSubscriber<Mine_WszlHqRsp>(mErrorHandler) {
                    @Override
                    public void onNext(Mine_WszlHqRsp data) {
                        if (data.getCode() == Api.SUCCESS) {
                            mRootView.loadDataSuccess(data);
                        }
                    }
                });
    }

    public void loadTxSave() {
        mModel.loadTxSave()
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
                .subscribe(new ErrorHandleSubscriber<MineWszlSaveRsp>(mErrorHandler) {
                    @Override
                    public void onNext(MineWszlSaveRsp data) {
                        ArmsUtils.makeText(mApplication, data.getMsg());
                        if (data.getCode() == Api.SUCCESS) {
                            mRootView.loadSaveSuccess(data);
                        }
                    }
                });
    }

    public void loadSave() {
        mModel.loadSave()
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
                .subscribe(new ErrorHandleSubscriber<MineWszlSaveRsp>(mErrorHandler) {
                    @Override
                    public void onNext(MineWszlSaveRsp data) {
                        ArmsUtils.makeText(mApplication, data.getMsg());
                        if (data.getCode() == Api.SUCCESS) {
                            mRootView.loadSaveSuccess(data);
                        }
                    }
                });
    }

}
