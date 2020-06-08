package com.argent.aiyunzan.MAIN.mvp.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.argent.aiyunzan.R;
import com.argent.aiyunzan.common.model.constant.SPConstants;
import com.argent.aiyunzan.common.utils.SmsTimeUtils;
import com.argent.aiyunzan.common.utils.WeiboDialogUtils;
import com.argent.aiyunzan.common.widget.ObserverButton;
import com.blankj.utilcode.util.SPUtils;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.argent.aiyunzan.MAIN.di.component.DaggerLoginForgetComponent;
import com.argent.aiyunzan.MAIN.mvp.contract.LoginForgetContract;
import com.argent.aiyunzan.MAIN.mvp.presenter.LoginForgetPresenter;


import butterknife.BindView;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


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
public class LoginForgetActivity extends BaseActivity<LoginForgetPresenter> implements LoginForgetContract.View {

    @BindView(R.id.btn_confirm)
    ObserverButton btn_confirm;
    @BindView(R.id.tv_code)
    TextView tv_code;
    @BindView(R.id.et_mobile)
    EditText et_mobile;
    @BindView(R.id.et_pass)
    EditText et_pass;
    @BindView(R.id.et_password)
    EditText et_password;
    @BindView(R.id.et_verifi)
    EditText et_verifi;

    private Dialog mWeiboDialog;

    @OnClick({R.id.btn_confirm, R.id.tv_code})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm:
                loadConfirm(et_verifi, et_mobile, et_pass, et_password);
                break;
            case R.id.tv_code:
                loadGetCode(et_mobile);
                break;
        }
    }

    private void loadConfirm(EditText et_verifi, EditText et_mobile, EditText et_pass, EditText et_password) {
        mPresenter.loadConfirm(getText(et_verifi), getText(et_mobile),
                getText(et_pass),
                getText(et_password));

    }

    private void loadGetCode(EditText et_mobile) {
        SmsTimeUtils.check(SmsTimeUtils.SETTING_FINANCE_ACCOUNT_TIME, false);
        SmsTimeUtils.startCountdown(tv_code);
        mPresenter.loadGetCode(getText(et_mobile));
    }


    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerLoginForgetComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_login_forget; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initView();
    }

    private void initView() {
        SPUtils.getInstance().put(SPConstants.ISLOGIN,false);

        if (SmsTimeUtils.check(SmsTimeUtils.SETTING_FINANCE_ACCOUNT_TIME, true)) {
            SmsTimeUtils.startCountdown(tv_code);
        }else{
            tv_code.setEnabled(true);
        }
        btn_confirm.observerEnable(et_verifi, et_mobile, et_pass, et_password);
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
