package com.argent.aiyunzan.MINE.mvp.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.argent.aiyunzan.R;
import com.argent.aiyunzan.common.model.bean.response.MineWdtdRsp;
import com.argent.aiyunzan.common.model.constant.SPConstants;
import com.argent.aiyunzan.common.utils.WeiboDialogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.argent.aiyunzan.MINE.di.component.DaggerMine_Menu1Component;
import com.argent.aiyunzan.MINE.mvp.contract.Mine_Menu1Contract;
import com.argent.aiyunzan.MINE.mvp.presenter.Mine_Menu1Presenter;


import butterknife.BindView;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 14:59
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class Mine_Menu1Activity extends BaseActivity<Mine_Menu1Presenter> implements Mine_Menu1Contract.View {

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.tv_1)
    TextView tv_1;
    @BindView(R.id.tv_2)
    TextView tv_2;

    private Dialog mWeiboDialog;

    @OnClick({R.id.rl_click1, R.id.rl_click2})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_click1:
                SPUtils.getInstance().put(SPConstants.TDTYPE, "1");
                launchActivity(new Intent(this, Mine_Menu1Click1Activity.class));
                break;
            case R.id.rl_click2:
                SPUtils.getInstance().put(SPConstants.TDTYPE, "2");
                launchActivity(new Intent(this, Mine_Menu1Click2Activity.class));
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        toolbar_title.setText("我的团队");
    }


    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMine_Menu1Component //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_mine__menu1; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
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
    public void loadHomeSuccess(MineWdtdRsp datas) {
        MineWdtdRsp.DataBean data = datas.getData();
        tv_1.setText(data.getOnelevel() + "");
        tv_2.setText(data.getTwolevel() + "");
    }
}
