package com.argent.aiyunzan.MAIN.mvp.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;

import com.argent.aiyunzan.R;
import com.argent.aiyunzan.common.model.bean.response.MineMenu6BbgxRsp;
import com.argent.aiyunzan.common.model.constant.ModelInfo;
import com.argent.aiyunzan.common.utils.CommonUtils;
import com.argent.aiyunzan.common.utils.WeiboDialogUtils;
import com.blankj.utilcode.util.AppUtils;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.argent.aiyunzan.MAIN.di.component.DaggerSplashComponent;
import com.argent.aiyunzan.MAIN.mvp.contract.SplashContract;
import com.argent.aiyunzan.MAIN.mvp.presenter.SplashPresenter;


import org.jetbrains.annotations.NotNull;

import constant.UiType;
import listener.Md5CheckResultListener;
import listener.UpdateDownloadListener;
import model.UiConfig;
import model.UpdateConfig;
import update.UpdateAppUtils;

import static com.argent.aiyunzan.MyApplication.getContext;
import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/30/2020 13:31
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.View {

    private Handler handler = new Handler();
    private Dialog mWeiboDialog;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerSplashComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_splash; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        mPresenter.loadData();//升级
    }

    private void isJump() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ModelInfo modelInfo = new ModelInfo();
                if (!TextUtils.isEmpty(modelInfo.getToken())) {//跳主页
                    Intent intent = new Intent(SplashActivity.this,
                            Main_Activity.class);
                    startActivity(intent);
                } else {//跳登录
                    Intent intent = new Intent(SplashActivity.this,
                            LoginActivity.class);
                    startActivity(intent);
                }
                killMyself();
            }
        }, 600);
    }

    @Override
    public void showLoading() {
        mWeiboDialog = WeiboDialogUtils.createLoadingDialog(this, "加载中...");
    }

    @Override
    public void hideLoading() {
        WeiboDialogUtils.closeDialog(mWeiboDialog);
    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    @Override
    public void loadDataSuccess(MineMenu6BbgxRsp datas) {
        MineMenu6BbgxRsp.DataBean data = datas.getData();
        String android_url = data.getAndroid_url();
        String android_number = data.getAndroid_number();
        int resultCode = CommonUtils.compareVersion(AppUtils.getAppVersionName(), android_number);
        switch (resultCode) {
            case 0:
                isJump();
                break;
            case 1:
                isJump();
                break;
            case -1://更新版本
                UpdateConfig updateConfig = new UpdateConfig();
                updateConfig.setCheckWifi(true);
                updateConfig.setNeedCheckMd5(true);
                updateConfig.setForce(true);
                updateConfig.setNotifyImgRes(R.drawable.splash_logo);

                UiConfig uiConfig = new UiConfig();
                uiConfig.setUiType(UiType.PLENTIFUL);

                UpdateAppUtils
                        .getInstance()
                        .apkUrl(android_url)
                        .updateTitle("发现新版本V" + android_number)
                        .updateContent("")
                        .uiConfig(uiConfig)
                        .updateConfig(updateConfig)
                        .setMd5CheckResultListener(new Md5CheckResultListener() {
                            @Override
                            public void onResult(boolean result) {
                                // true：检验通过，false：检验失败
                            }
                        })
                        .setUpdateDownloadListener(new UpdateDownloadListener() {
                            @Override
                            public void onStart() {

                            }

                            @Override
                            public void onDownload(int progress) {

                            }

                            @Override
                            public void onFinish() {

                            }

                            @Override
                            public void onError(@NotNull Throwable e) {

                            }
                        })
                        .update();
                break;
        }
    }
}
