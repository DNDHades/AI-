package com.argent.aiyunzan.HOME.mvp.ui.activity;

import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.argent.aiyunzan.HOME.di.component.DaggerHome_Menu5Component;
import com.argent.aiyunzan.HOME.mvp.contract.Home_Menu5Contract;
import com.argent.aiyunzan.HOME.mvp.presenter.Home_Menu5Presenter;
import com.argent.aiyunzan.R;
import com.argent.aiyunzan.common.model.bean.response.HomeMenu5Kfzx1Rsp;
import com.argent.aiyunzan.common.model.constant.SPConstants;
import com.argent.aiyunzan.common.utils.WeiboDialogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 08:56
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class Home_Menu5Activity extends BaseActivity<Home_Menu5Presenter> implements Home_Menu5Contract.View {

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.tv_time)
    TextView tv_time;
    @BindView(R.id.tv_qq1)
    TextView tv_qq1;
    @BindView(R.id.tv_qq2)
    TextView tv_qq2;
    @BindView(R.id.tv_qq3)
    TextView tv_qq3;
    @BindView(R.id.tv_wx1)
    TextView tv_wx1;
    @BindView(R.id.tv_wx2)
    TextView tv_wx2;
    @BindView(R.id.tv_wx3)
    TextView tv_wx3;

    private String QQ1 = "";
    private String QQ2 = "";
    private String QQ3 = "";
    private Dialog mWeiboDialog;

    @OnClick({R.id.rl_click1, R.id.rl_click2, R.id.rl_click3, R.id.rl_click4, R.id.rl_click5,
            R.id.rl_click6})
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
            case R.id.rl_click5:
                startQQ(QQ3);
                break;
            case R.id.rl_click6:
                SPUtils.getInstance().put(SPConstants.WXNUMBER, "3");
                launchActivity(new Intent(this, Home_Menu5Click1Activity.class));
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        toolbar_title.setText("客服中心");
    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerHome_Menu5Component //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_home__menu5; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        mPresenter.loadKfzx1Data();
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

    private void startQQ(String qq) {

        ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        cm.setText(qq);
        Toast.makeText(this, "复制成功", Toast.LENGTH_LONG).show();

//        if (isQQInstall(getContext())) {
//            final String qqUrl = "mqqwpa://im/chat?chat_type=wpa&uin=" + qq;
//            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(qqUrl)));
//        } else {
//            ToastUtils.showShort("请安装QQ客户端");
//        }

    }

    @Override
    public void loadHomeSuccess(HomeMenu5Kfzx1Rsp datas) {
        HomeMenu5Kfzx1Rsp.DataBean data = datas.getData();
        QQ1 = data.getQqone();
        QQ2 = data.getQqtwo();
        QQ3 = data.getVip_team_service_qq();
        tv_qq1.setText(QQ1 + "");
        tv_qq2.setText(QQ2 + "");
        tv_qq3.setText(QQ3 + "");
        tv_time.setText("工作时间：" + data.getKefu_time() + "");
        tv_wx1.setText(data.getWxone() + "");
        tv_wx2.setText(data.getWxtwo() + "");
        tv_wx3.setText(data.getVip_team_service_wechat() + "");
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

}
