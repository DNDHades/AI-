package com.argent.aiyunzan.MINE.mvp.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.argent.aiyunzan.R;
import com.argent.aiyunzan.common.model.bean.response.MineSrmxRsp;
import com.argent.aiyunzan.common.model.constant.SPConstants;
import com.argent.aiyunzan.common.utils.WeiboDialogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.argent.aiyunzan.MINE.di.component.DaggerMine_SrmxComponent;
import com.argent.aiyunzan.MINE.mvp.contract.Mine_SrmxContract;
import com.argent.aiyunzan.MINE.mvp.presenter.Mine_SrmxPresenter;


import butterknife.BindView;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 17:00
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class Mine_SrmxActivity extends BaseActivity<Mine_SrmxPresenter> implements Mine_SrmxContract.View {

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.tv_time1)
    TextView tv_time1;
    @BindView(R.id.tv_time2)
    TextView tv_time2;
    @BindView(R.id.tv_time3)
    TextView tv_time3;
    @BindView(R.id.tv_time4)
    TextView tv_time4;
    @BindView(R.id.tv_time5)
    TextView tv_time5;
    @BindView(R.id.tv_click)
    TextView tv_click;
    @BindView(R.id.tv_share)
    TextView tv_share;
    @BindView(R.id.tv_team)
    TextView tv_team;
    @BindView(R.id.tv_luck)
    TextView tv_luck;
    @BindView(R.id.tv_other)
    TextView tv_other;
    @BindView(R.id.tv_all_profit)
    TextView tv_all_profit;
    @BindView(R.id.tv_myprofit)
    TextView tv_myprofit;
    @BindView(R.id.tv_werden)
    TextView tv_werden;
    @BindView(R.id.tv_1)
    TextView tv_1;
    @BindView(R.id.tv_2)
    TextView tv_2;
    @BindView(R.id.tv_3)
    TextView tv_3;
    @BindView(R.id.tv_4)
    TextView tv_4;
    @BindView(R.id.tv_5)
    TextView tv_5;

    private Dialog mWeiboDialog;

    @OnClick({R.id.rl_click1, R.id.rl_click2, R.id.rl_click3, R.id.rl_click4, R.id.rl_click5})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_click1:
                SPUtils.getInstance().put(SPConstants.TDTYPE, "1");
                SPUtils.getInstance().put(SPConstants.SYMXNAME, getText(tv_1)+"");
                launchActivity(new Intent(this,Mine_SrmxClickActivity.class));
                break;
            case R.id.rl_click2:
                SPUtils.getInstance().put(SPConstants.TDTYPE, "2");
                SPUtils.getInstance().put(SPConstants.SYMXNAME, getText(tv_2)+"");
                launchActivity(new Intent(this,Mine_SrmxClickActivity.class));
                break;
            case R.id.rl_click3:
                SPUtils.getInstance().put(SPConstants.TDTYPE, "3");
                SPUtils.getInstance().put(SPConstants.SYMXNAME, getText(tv_3)+"");
                launchActivity(new Intent(this,Mine_SrmxClickActivity.class));
                break;
            case R.id.rl_click4:
                SPUtils.getInstance().put(SPConstants.TDTYPE, "5");
                SPUtils.getInstance().put(SPConstants.SYMXNAME, getText(tv_4)+"");
                launchActivity(new Intent(this,Mine_SrmxClickActivity.class));
                break;
            case R.id.rl_click5:
                SPUtils.getInstance().put(SPConstants.TDTYPE, "4");
                SPUtils.getInstance().put(SPConstants.SYMXNAME, getText(tv_5)+"");
                launchActivity(new Intent(this,Mine_SrmxClickActivity.class));
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        toolbar_title.setText("收入明细");
    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMine_SrmxComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_mine__srmx; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        mPresenter.loadData();
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
    public void loadHomeSuccess(MineSrmxRsp datas) {
        MineSrmxRsp.DataBean data = datas.getData();
        tv_time1.setText(datas.getTime() + "");
        tv_time2.setText(datas.getTime() + "");
        tv_time3.setText(datas.getTime() + "");
        tv_time4.setText(datas.getTime() + "");
        tv_time5.setText(datas.getTime() + "");
        tv_share.setText(data.getShare() + "元");
        tv_team.setText(data.getTeam() + "元");
        tv_click.setText(data.getClick() + "元");
        tv_luck.setText(data.getLuck() + "元");
        tv_other.setText(data.getOther() + "元");
        tv_all_profit.setText(data.getAll_profit() + "");
        tv_myprofit.setText(data.getMyprofit() + "");
        tv_werden.setText(data.getWerden() + "");
    }

    private String getText(TextView textView) {
        return textView.getText().toString().trim();
    }
}
