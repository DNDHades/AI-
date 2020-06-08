package com.argent.aiyunzan.MAIN.mvp.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
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

import com.argent.aiyunzan.MAIN.di.component.DaggerRegisterComponent;
import com.argent.aiyunzan.MAIN.mvp.contract.RegisterContract;
import com.argent.aiyunzan.MAIN.mvp.presenter.RegisterPresenter;


import butterknife.BindView;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/30/2020 14:13
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterContract.View {

    @BindView(R.id.btn_register)
    ObserverButton btn_register;
    @BindView(R.id.tv_code)
    TextView tv_code;
    @BindView(R.id.et_code)
    EditText et_code;
    @BindView(R.id.et_mobile)
    EditText et_mobile;
    @BindView(R.id.et_password)
    EditText et_password;
    @BindView(R.id.et_secret)
    EditText et_secret;
    @BindView(R.id.et_verifi)
    EditText et_verifi;

    private Dialog mWeiboDialog;

    @OnClick({R.id.btn_register, R.id.tv_code})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                loadRegister(et_mobile, et_verifi, et_password, et_secret, et_code);
                break;
            case R.id.tv_code:
                loadGetCode(et_mobile);
                break;
        }
    }

    private void loadGetCode(EditText et_mobile) {
        if(!TextUtils.isEmpty(getText(et_mobile))){
            SmsTimeUtils.check(SmsTimeUtils.SETTING_FINANCE_ACCOUNT_TIME, false);
            SmsTimeUtils.startCountdown(tv_code);
            mPresenter.loadGetCode(getText(et_mobile));
        }else{
            ArmsUtils.makeText(this,"手机号码不能为空");
        }
    }

    private void loadRegister(EditText et_mobile, EditText et_verifi, EditText et_password,
                              EditText et_secret, EditText et_code) {
        mPresenter.loadRegister(getText(et_mobile), getText(et_verifi), getText(et_password),
                getText(et_secret), getText(et_code));
    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerRegisterComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_register; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
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
        btn_register.observerEnable(et_mobile, et_verifi, et_password, et_secret, et_code);
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

    public String getText(EditText editText) {
        return editText.getText().toString().trim();
    }

}
