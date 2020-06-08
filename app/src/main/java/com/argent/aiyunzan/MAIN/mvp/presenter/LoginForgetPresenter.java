package com.argent.aiyunzan.MAIN.mvp.presenter;

import android.app.Application;

import com.argent.aiyunzan.common.model.api.Api;
import com.argent.aiyunzan.common.model.bean.response.LoginForgetRsp;
import com.argent.aiyunzan.common.model.bean.response.LoginGetCodeRsp;
import com.argent.aiyunzan.common.model.constant.SPConstants;
import com.blankj.utilcode.util.SPUtils;
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

import com.argent.aiyunzan.MAIN.mvp.contract.LoginForgetContract;
import com.jess.arms.utils.ArmsUtils;
import com.jess.arms.utils.RxLifecycleUtils;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/30/2020 14:41
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
public class LoginForgetPresenter extends BasePresenter<LoginForgetContract.Model, LoginForgetContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public LoginForgetPresenter(LoginForgetContract.Model model, LoginForgetContract.View rootView) {
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

    public void loadGetCode(String et_mobile) {
        mModel.loadGetCode(et_mobile)
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
                .subscribe(new ErrorHandleSubscriber<LoginGetCodeRsp>(mErrorHandler) {
                    @Override
                    public void onNext(LoginGetCodeRsp data) {
                        ArmsUtils.makeText(mApplication, data.getMsg());
                    }
                });
    }

    public void loadConfirm(String et_verifi,
                            String et_mobile,
                            String et_pass,
                            String et_password) {
        mModel.loadConfirm(et_verifi, et_mobile, et_pass, et_password)
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
                .subscribe(new ErrorHandleSubscriber<LoginForgetRsp>(mErrorHandler) {
                    @Override
                    public void onNext(LoginForgetRsp data) {
                        ArmsUtils.makeText(mApplication, data.getMsg());
                        if (data.getCode() == Api.SUCCESS) {
                            SPUtils.getInstance().put(SPConstants.TOKEN, data.getData().getToken() + "");
                            SPUtils.getInstance().put(SPConstants.UID, data.getData().getUid() + "");
                            mRootView.killMyself();
                        }
                    }
                });
    }
}
