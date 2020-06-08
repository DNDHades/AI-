package com.argent.aiyunzan.MINE.mvp.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.argent.aiyunzan.R;
import com.argent.aiyunzan.common.model.bean.response.MineMenu3HqxxRsp;
import com.argent.aiyunzan.common.utils.CheckBankCardUtils;
import com.argent.aiyunzan.common.utils.OptionsPickerViewUtils;
import com.argent.aiyunzan.common.utils.SmsTimeUtils;
import com.argent.aiyunzan.common.utils.WeiboDialogUtils;
import com.argent.aiyunzan.common.widget.CustomEditText;
import com.argent.aiyunzan.common.widget.ObserverButton;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.blankj.utilcode.util.RegexUtils;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.argent.aiyunzan.MINE.di.component.DaggerMine_Menu3Component;
import com.argent.aiyunzan.MINE.mvp.contract.Mine_Menu3Contract;
import com.argent.aiyunzan.MINE.mvp.presenter.Mine_Menu3Presenter;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 15:19
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class Mine_Menu3Activity extends BaseActivity<Mine_Menu3Presenter> implements Mine_Menu3Contract.View {

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.et_username)
    EditText et_username;
    @BindView(R.id.et_card_name)
    CustomEditText et_card_name;
    @BindView(R.id.et_card_number)
    EditText et_card_number;
    @BindView(R.id.et_mobile)
    EditText et_mobile;
    @BindView(R.id.tv_code)
    TextView tv_code;
    @BindView(R.id.et_verifi)
    EditText et_verifi;
    @BindView(R.id.et_pass)
    EditText et_pass;
    @BindView(R.id.btn_login)
    ObserverButton btn_login;
    @BindView(R.id.rl_1)
    RelativeLayout rl_1;
    @BindView(R.id.rl_2)
    RelativeLayout rl_2;
    @BindView(R.id.rl_3)
    RelativeLayout rl_3;

    private List<String> optionData = new ArrayList<>(Arrays.asList("中国银行", "交通银行",
            "邮政银行", "农业银行", "建设银行", "平安银行", "工商银行", "招商银行"));
    private Dialog mWeiboDialog;


    @OnClick({R.id.rl_khhmc, R.id.tv_code, R.id.btn_login})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_khhmc:
                OptionsPickerView show = new OptionsPickerViewUtils(this).show(optionData, et_card_name);
                show.setTitleText("选择银行名称");
                break;
            case R.id.tv_code:
                loadGetCode(et_mobile);
                break;
            case R.id.btn_login:
                postData(et_username, et_card_name, et_card_number, et_mobile, et_verifi, et_pass);
                break;
        }
    }

    private void postData(EditText et_username, CustomEditText et_card_name,
                          EditText et_card_number, EditText et_mobile,
                          EditText et_verifi, EditText et_pass) {
        if (!CheckBankCardUtils.checkBankCard(getText(et_card_number))) {
            ArmsUtils.makeText(this, "请输入正确的银行卡号");
        } else {
            mPresenter.loadPostData(getText(et_username), getText(et_card_name),
                    getText(et_card_number),
                    getText(et_mobile), getText(et_verifi), getText(et_pass));
        }
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
        toolbar_title.setText("完善提现资料");
    }


    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMine_Menu3Component //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_mine__menu3; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initView();
        mPresenter.loadData();
    }

    private void initView() {
        if (SmsTimeUtils.check(SmsTimeUtils.HUOQU, true)) {
            SmsTimeUtils.startCountdown(tv_code);
        } else {
            tv_code.setEnabled(true);
        }
        btn_login.observerEnable(et_username, et_card_name, et_card_number, et_mobile, et_verifi, et_pass);
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
    public void loadHomeSuccess(MineMenu3HqxxRsp datas) {
        MineMenu3HqxxRsp.DataBean data = datas.getData();
        if (data != null) {
            if(!TextUtils.isEmpty(data.getUsername())){
                et_username.setText(data.getUsername() + "");
                et_card_name.setText(data.getCard_name() + "");
                et_card_number.setText(data.getCard_number() + "");
                et_mobile.setText(data.getMobile() + "");
                et_username.setEnabled(false);
                et_card_name.setEnabled(false);
                et_card_number.setEnabled(false);

                rl_1.setVisibility(View.GONE);
                rl_2.setVisibility(View.GONE);
                rl_3.setVisibility(View.GONE);
                btn_login.setVisibility(View.GONE);
            }else{
                rl_1.setVisibility(View.VISIBLE);
                rl_2.setVisibility(View.VISIBLE);
                rl_3.setVisibility(View.VISIBLE);
                btn_login.setVisibility(View.VISIBLE);
            }
        }
    }
}
