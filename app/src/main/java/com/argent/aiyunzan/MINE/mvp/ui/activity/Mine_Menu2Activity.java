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

import com.argent.aiyunzan.MINE.di.component.DaggerMine_Menu2Component;
import com.argent.aiyunzan.MINE.mvp.contract.Mine_Menu2Contract;
import com.argent.aiyunzan.MINE.mvp.presenter.Mine_Menu2Presenter;
import com.argent.aiyunzan.R;
import com.argent.aiyunzan.common.model.bean.response.MineMenu2HqsjRsp;
import com.argent.aiyunzan.common.model.bean.response.MineMenu2TjRsp;
import com.argent.aiyunzan.common.model.constant.SPConstants;
import com.argent.aiyunzan.common.utils.EdittextDialogUtils;
import com.argent.aiyunzan.common.utils.WeiboDialogUtils;
import com.argent.aiyunzan.common.widget.Dialog.MessageDialog;
import com.blankj.utilcode.util.SPUtils;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 15:03
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class Mine_Menu2Activity extends BaseActivity<Mine_Menu2Presenter> implements Mine_Menu2Contract.View {

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.et_money)
    EditText et_money;
    @BindView(R.id.tv_werden_min)
    TextView tv_werden_min;
    @BindView(R.id.tv_werden_feel)
    TextView tv_werden_feel;
    @BindView(R.id.tv_such_time)
    TextView tv_such_time;
    @BindView(R.id.tv_change)
    TextView tv_change;
    @BindView(R.id.btn_confirm)
    Button btn_confirm;
    @BindView(R.id.btn_confirm_zfb)
    Button btnConfirmZfb;

    private EdittextDialogUtils edittextDialogUtils;
    private Dialog mWeiboDialog;
    private String bankcard = "0";//用户是否已绑定银行卡,1已绑定,0未绑定

    @OnClick({R.id.btn_confirm})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm:
                loadPostData(1);
                break;
            case R.id.btn_confirm_zfb:
                loadPostData(2);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        toolbar_title.setText("立即提现");
    }

    private void loadPostData(int type) {
        if (!TextUtils.isEmpty(getText(et_money))) {
            Integer integer = Integer.valueOf(getText(et_money));
            if (integer <= 0) {
                ArmsUtils.makeText(this, "输入金额不正确");
            } else if (bankcard.equals("0")) {//用户是否已绑定银行卡,1已绑定,0未绑定
                new MessageDialog(this, "提示", "请先完善提现信息再操作提现！").show();
            } else if (bankcard.equals("1")) {//用户是否已绑定银行卡,1已绑定,0未绑定
                edittextDialogUtils = new EdittextDialogUtils();
                edittextDialogUtils.showCustomizeDialog(this, new EdittextDialogUtils.Listener() {
                    @Override
                    public void onClick(String pass) {
                        if (!TextUtils.isEmpty(pass)) {
                            String money = getText(et_money);
                            SPUtils.getInstance().put(SPConstants.MONEY, money);
                            SPUtils.getInstance().put(SPConstants.PASS, pass);
                            SPUtils.getInstance().put(SPConstants.TYPE,type);
                            mPresenter.loadPostData();
                        } else {
                            ArmsUtils.makeText(Mine_Menu2Activity.this,
                                    "提现密码不能为空");
                        }
                    }
                });
            }
        } else {
            ArmsUtils.makeText(this, "请输入提现金额");
        }
    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMine_Menu2Component //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_mine__menu2; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initView();
        mPresenter.loadData();
    }

    private void initView() {
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
    public void loadHomeSuccess(MineMenu2HqsjRsp datas) {
        MineMenu2HqsjRsp.DataBean data = datas.getData();
        tv_werden_min.setText("1、提现的金额必须是" + data.getWerden_min() + "元的倍数才能提现！");
        tv_werden_feel.setText("2、每提现一次扣除手续费" + data.getWerden_feel() + "元，提现不限额度！");
        tv_such_time.setText("3、提现时间：" + data.getSuch_time());
        tv_change.setText("余额:" + data.getChange() + "元");
        bankcard = data.getBankcard() + "";
    }

    @Override
    public void loadPostDataComplete(MineMenu2TjRsp data) {
        ArmsUtils.makeText(this, data.getMsg() + "");
        edittextDialogUtils.cancel();
    }
}
