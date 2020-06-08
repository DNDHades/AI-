package com.argent.aiyunzan.MAIN.mvp.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.argent.aiyunzan.R;
import com.argent.aiyunzan.common.model.constant.SPConstants;
import com.argent.aiyunzan.common.utils.WeiboDialogUtils;
import com.argent.aiyunzan.common.widget.ObserverButton;
import com.blankj.utilcode.util.SPUtils;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.argent.aiyunzan.MAIN.di.component.DaggerLoginComponent;
import com.argent.aiyunzan.MAIN.mvp.contract.LoginContract;
import com.argent.aiyunzan.MAIN.mvp.presenter.LoginPresenter;


import butterknife.BindView;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/30/2020 13:48
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.et_phone)
    EditText et_phone;
    @BindView(R.id.et_pwd)
    EditText et_pwd;
    @BindView(R.id.btn_login)
    ObserverButton btn_login;

    private Dialog mWeiboDialog;

    @OnClick({R.id.tv_forget, R.id.tv_authcode, R.id.btn_register, R.id.btn_login})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_forget:
                launchActivity(new Intent(this, LoginForgetActivity.class));
                break;
            case R.id.tv_authcode:
                launchActivity(new Intent(this, LoginAuthCodeActivity.class));
                break;
            case R.id.btn_register:
                launchActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.btn_login:
                loadLogin(et_phone, et_pwd);
                break;
        }
    }

    private void loadLogin(EditText et_phone, EditText et_pwd) {
        mPresenter.loadLogin(getText(et_phone), getText(et_pwd));
    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerLoginComponent //如找不到该类,请编译一下项目
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
        return R.layout.activity_login; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initView();
    }

    private void initView() {
        SPUtils.getInstance().remove(SPConstants.TOKEN);//删掉登录信息
        SPUtils.getInstance().put(SPConstants.ISLOGIN,false);

        btn_login.observerEnable(et_phone, et_pwd);
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
    public void loadLoginSucess() {
        launchActivity(new Intent(this, Main_Activity.class));
        killMyself();
    }

    public String getText(EditText editText) {
        return editText.getText().toString().trim();
    }

}
