package com.argent.aiyunzan.MINE.mvp.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.argent.aiyunzan.R;
import com.argent.aiyunzan.common.model.constant.SPConstants;
import com.argent.aiyunzan.common.utils.SmsTimeUtils;
import com.argent.aiyunzan.common.utils.WeiboDialogUtils;
import com.argent.aiyunzan.common.widget.ObserverButton;
import com.blankj.utilcode.util.SPUtils;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.argent.aiyunzan.MINE.di.component.DaggerMine_Menu4Component;
import com.argent.aiyunzan.MINE.mvp.contract.Mine_Menu4Contract;
import com.argent.aiyunzan.MINE.mvp.presenter.Mine_Menu4Presenter;


import butterknife.BindView;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 15:54
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class Mine_Menu4Activity extends BaseActivity<Mine_Menu4Presenter> implements Mine_Menu4Contract.View {

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.tv_code)
    TextView tv_code;
    @BindView(R.id.et_mobile)
    EditText et_mobile;
    @BindView(R.id.et_verifi)
    EditText et_verifi;
    @BindView(R.id.et_newpass)
    EditText et_newpass;
    @BindView(R.id.et_pass)
    EditText et_pass;
    @BindView(R.id.btn_confim)
    ObserverButton btn_confim;

    private Dialog mWeiboDialog;

    @OnClick({R.id.tv_code, R.id.btn_confim})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_code:
                loadGetCode(et_mobile);
                break;
            case R.id.btn_confim:
                loadPostData(et_mobile, et_verifi, et_newpass, et_pass);
                break;
        }
    }

    private void loadPostData(EditText et_mobile, EditText et_verifi,
                              EditText et_newpass, EditText et_pass) {
        mPresenter.loadPostData(getText(et_mobile), getText(et_verifi),
                getText(et_newpass), getText(et_pass));
    }

    private void loadGetCode(EditText et_mobile) {
        if (!TextUtils.isEmpty(getText(et_mobile))) {
            SmsTimeUtils.check(SmsTimeUtils.HUOQU, false);
            SmsTimeUtils.startCountdown(tv_code);
            mPresenter.loadGetCode(getText(et_mobile));
        } else {
            ArmsUtils.makeText(this, "手机号码不能为空");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        toolbar_title.setText("提现改密");
    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMine_Menu4Component //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_mine__menu4; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initView();
    }

    private void initView() {
        if (SmsTimeUtils.check(SmsTimeUtils.HUOQU, true)) {
            SmsTimeUtils.startCountdown(tv_code);
        } else {
            tv_code.setEnabled(true);
        }
        btn_confim.observerEnable(et_mobile, et_verifi, et_newpass, et_pass);
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

}
