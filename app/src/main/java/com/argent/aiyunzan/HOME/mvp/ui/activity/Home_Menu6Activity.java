package com.argent.aiyunzan.HOME.mvp.ui.activity;

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
import com.argent.aiyunzan.common.model.bean.response.HomeMenu6XszyRsp;
import com.argent.aiyunzan.common.model.constant.SPConstants;
import com.argent.aiyunzan.common.utils.WeiboDialogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.argent.aiyunzan.HOME.di.component.DaggerHome_Menu6Component;
import com.argent.aiyunzan.HOME.mvp.contract.Home_Menu6Contract;
import com.argent.aiyunzan.HOME.mvp.presenter.Home_Menu6Presenter;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 09:16
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class Home_Menu6Activity extends BaseActivity<Home_Menu6Presenter> implements Home_Menu6Contract.View {

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.rv_content)
    RecyclerView rv_content;

    private BaseQuickAdapter<HomeMenu6XszyRsp.DataBean, BaseViewHolder> mAdapter;
    private List<HomeMenu6XszyRsp.DataBean> dataBeanList = new ArrayList<>();
    private Dialog mWeiboDialog;

    @Override
    protected void onResume() {
        super.onResume();
        toolbar_title.setText("新手指引");
    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerHome_Menu6Component //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_home__menu6; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initView();
        initListener();
        mPresenter.loadData();
    }

    private void initListener() {
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                List<HomeMenu6XszyRsp.DataBean> datas = adapter.getData();
                SPUtils.getInstance().put(SPConstants.ARTICLE_ID, datas.get(position).getArticle_id() + "");
                launchActivity(new Intent(Home_Menu6Activity.this,
                        Home_Menu6XqActivity.class));
            }
        });
    }

    private void initView() {
        rv_content.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new BaseQuickAdapter<HomeMenu6XszyRsp.DataBean, BaseViewHolder>(R.layout.item_home_xszy, dataBeanList) {
            @Override
            protected void convert(@NonNull BaseViewHolder helper, HomeMenu6XszyRsp.DataBean item) {
                helper.setText(R.id.tv_text, item.getTitle() + "");
            }
        };

        rv_content.setAdapter(mAdapter);
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
    public void loadHomeSuccess(List<HomeMenu6XszyRsp.DataBean> data) {
        mAdapter.setNewData(data);
        mAdapter.notifyDataSetChanged();
    }
}
