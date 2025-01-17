package com.argent.aiyunzan.HOME.mvp.presenter;

import android.app.Application;
import android.widget.Toast;

import com.argent.aiyunzan.common.model.bean.response.HomeMenu4BuyWxRsp;
import com.argent.aiyunzan.common.model.bean.response.HomeMenu4BuyZfbRsp;
import com.argent.aiyunzan.common.model.bean.response.Home_Menu4HqxtjeRps;
import com.argent.aiyunzan.common.utils.RxUtils;
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

import com.argent.aiyunzan.HOME.mvp.contract.Home_Menu4Contract;
import com.jess.arms.utils.RxLifecycleUtils;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/30/2020 19:31
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
public class Home_Menu4Presenter extends BasePresenter<Home_Menu4Contract.Model, Home_Menu4Contract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public Home_Menu4Presenter(Home_Menu4Contract.Model model, Home_Menu4Contract.View rootView) {
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

    public void loadHqxtjeData() {
        mModel.loadHqxtjeData()
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
                .subscribe(new ErrorHandleSubscriber<Home_Menu4HqxtjeRps>(mErrorHandler) {
                    @Override
                    public void onNext(Home_Menu4HqxtjeRps data) {
                        if (data.getCode() == 200) {
                            mRootView.loadHqxtjeDataSuccess(data);
                        } else if (data.getCode() == 302){
                            Toast.makeText(mApplication, data.getMsg() , Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void loadDataBuyWx(int member){
        mModel.loadDataBuyWx(member+"")
                .compose(RxUtils.applySchedulers(mRootView))//使用 Rxlifecycle,使 Disposable 和 Activity 一起销毁
                .subscribe(new ErrorHandleSubscriber<HomeMenu4BuyWxRsp>(mErrorHandler) {
                    @Override
                    public void onNext(HomeMenu4BuyWxRsp data) {
                        if (data.getCode().equals("200")) {
                            mRootView.loadDataBuyWxSuccess(data);
                        }else if (data.getCode().equals("302")){
                            Toast.makeText(mApplication, data.getMsg(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void loadDataBuyZfb(int member) {
        mModel.loadDataBuyZfb(member+"")
                .compose(RxUtils.applySchedulers(mRootView))//使用 Rxlifecycle,使 Disposable 和 Activity 一起销毁
                .subscribe(new ErrorHandleSubscriber<HomeMenu4BuyZfbRsp>(mErrorHandler) {
                    @Override
                    public void onNext(HomeMenu4BuyZfbRsp data) {
                        if (data.getCode()==200) {
                            mRootView.loadDataBuyZfbSuccess(data);
                        } else if (data.getCode() == 302){
                            Toast.makeText(mApplication, data.getMsg(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
