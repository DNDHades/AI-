package com.argent.aiyunzan.MINE.mvp.ui.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.argent.aiyunzan.HOME.mvp.ui.activity.Home_Menu5Click1Activity;
import com.argent.aiyunzan.R;
import com.argent.aiyunzan.common.model.bean.response.HomeMenu5Kfzx1Rsp;
import com.argent.aiyunzan.common.model.bean.response.MineMenu6BbgxRsp;
import com.argent.aiyunzan.common.model.constant.SPConstants;
import com.argent.aiyunzan.common.utils.CommonUtils;
import com.argent.aiyunzan.common.utils.WeiboDialogUtils;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.argent.aiyunzan.MINE.di.component.DaggerMine_Menu6Component;
import com.argent.aiyunzan.MINE.mvp.contract.Mine_Menu6Contract;
import com.argent.aiyunzan.MINE.mvp.presenter.Mine_Menu6Presenter;


import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
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
 * Created by MVPArmsTemplate on 03/31/2020 16:16
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class Mine_Menu6Activity extends BaseActivity<Mine_Menu6Presenter> implements Mine_Menu6Contract.View {

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.tv_version)
    TextView tv_version;
    @BindView(R.id.tv_qq1)
    TextView tv_qq1;
    @BindView(R.id.tv_qq2)
    TextView tv_qq2;
    @BindView(R.id.tv_wx1)
    TextView tv_wx1;
    @BindView(R.id.tv_wx2)
    TextView tv_wx2;
    @BindView(R.id.tv_time)
    TextView tv_time;

    private String QQ1 = "";
    private String QQ2 = "";
    private Dialog mWeiboDialog;

    @OnClick({R.id.rl_click1, R.id.rl_click2, R.id.rl_click3, R.id.rl_click4, R.id.btn_click})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_click1:
                startQQ(QQ1);
                break;
            case R.id.rl_click2:
                startQQ(QQ2);
                break;
            case R.id.rl_click3:
                SPUtils.getInstance().put(SPConstants.WXNUMBER, "1");
                launchActivity(new Intent(this, Home_Menu5Click1Activity.class));
                break;
            case R.id.rl_click4:
                SPUtils.getInstance().put(SPConstants.WXNUMBER, "2");
                launchActivity(new Intent(this, Home_Menu5Click1Activity.class));
                break;
            case R.id.btn_click:
                mPresenter.loadClick();
                break;
        }
    }

    private void startQQ(String qq) {

        if (isQQInstall(getContext())) {
            final String qqUrl = "mqqwpa://im/chat?chat_type=wpa&uin=" + qq;
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(qqUrl)));
        } else {
            ToastUtils.showShort("请安装QQ客户端");
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        toolbar_title.setText("版本升级");
    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMine_Menu6Component //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_mine__menu6; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initView();
        mPresenter.loadKfzx1Data();
    }

    private void initView() {
        tv_version.setText("版本号：" + AppUtils.getAppVersionName());
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

    private boolean isQQInstall(Context context) {
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                //通过遍历应用所有包名进行判断
                if (pn.equals("com.tencent.mobileqq")) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void loadHomeSuccess(HomeMenu5Kfzx1Rsp datas) {
        HomeMenu5Kfzx1Rsp.DataBean data = datas.getData();
        QQ1 = data.getQqone();
        QQ2 = data.getQqtwo();
        tv_qq1.setText(QQ1 + "");
        tv_qq2.setText(QQ2 + "");
        tv_time.setText("工作时间：" + data.getKefu_time() + "");
        tv_wx1.setText(data.getWxone() + "");
        tv_wx2.setText(data.getWxtwo() + "");
    }

    @Override
    public void loadClickSuccess(MineMenu6BbgxRsp datas) {
        MineMenu6BbgxRsp.DataBean data = datas.getData();
        String android_url = data.getAndroid_url();
        String android_number = data.getAndroid_number();
        int resultCode = CommonUtils.compareVersion(AppUtils.getAppVersionName(), android_number);
        switch (resultCode) {
            case 0:
                ArmsUtils.makeText(getContext(), "当前已是最新版本");
                break;
            case 1:
                ArmsUtils.makeText(getContext(), "当前已是最新版本");
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
