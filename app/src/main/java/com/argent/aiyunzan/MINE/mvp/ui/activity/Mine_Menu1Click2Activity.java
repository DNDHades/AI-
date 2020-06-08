package com.argent.aiyunzan.MINE.mvp.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.argent.aiyunzan.R;
import com.argent.aiyunzan.common.model.bean.response.MineTdxqRsp;
import com.argent.aiyunzan.common.utils.WeiboDialogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.argent.aiyunzan.MINE.di.component.DaggerMine_Menu1Click2Component;
import com.argent.aiyunzan.MINE.mvp.contract.Mine_Menu1Click2Contract;
import com.argent.aiyunzan.MINE.mvp.presenter.Mine_Menu1Click2Presenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 04/02/2020 09:56
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class Mine_Menu1Click2Activity extends BaseActivity<Mine_Menu1Click2Presenter> implements Mine_Menu1Click2Contract.View {

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.rv_content)
    RecyclerView rv_content;
    @BindView(R.id.refreshLayout)
    RefreshLayout mRefreshLayout;

    private List<MineTdxqRsp.DataBean.Datas> list = new ArrayList<>();
    private BaseQuickAdapter<MineTdxqRsp.DataBean.Datas, BaseViewHolder> adapter;
    private int page = 1;
//    private Dialog mWeiboDialog;

    @Override
    protected void onResume() {
        super.onResume();
        toolbar_title.setText("二级会员");
    }


    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMine_Menu1Click2Component //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_mine__menu1_click2; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initView();
        initListenr();
        loadData(page);
    }

    private void loadData(int page) {
        mPresenter.loadData(page);
    }

    private void initListenr() {
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() { //下拉刷新
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page = 1;
                list.clear();
                loadData(page);
            }
        });

        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() { //上拉加载更多
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                page += 1;
                loadData(page);
            }
        });
    }

    private void initView() {
        rv_content.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BaseQuickAdapter<MineTdxqRsp.DataBean.Datas, BaseViewHolder>(R.layout.item_mine_tdxx, list) {
            @Override
            protected void convert(@NonNull BaseViewHolder helper, MineTdxqRsp.DataBean.Datas item) {
                helper.setText(R.id.tv_uid, item.getUid() + "");
                helper.setText(R.id.tv_time, item.getCreate_time() + "");
                if (item.getLevel() == 0) {//no
                    helper.setText(R.id.tv_level, "非会员");
                    helper.setTextColor(R.id.tv_level, Color.parseColor("#ffffff"));
                } else {
                    helper.setText(R.id.tv_level, "会员");
                    helper.setTextColor(R.id.tv_level, Color.parseColor("#FF0000"));
                }
            }
        };
        adapter.setEmptyView(R.layout.empty_box, rv_content);
        rv_content.setAdapter(adapter);

    }

    @Override
    public void showLoading() {
//        mWeiboDialog = WeiboDialogUtils.createLoadingDialog(this, "加载中...");
    }

    @Override
    public void hideLoading() {
//        WeiboDialogUtils.closeDialog(mWeiboDialog);
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
    public void loadHomeSuccess(MineTdxqRsp data) {
        List<MineTdxqRsp.DataBean.Datas> list = data.getData().getList();
        if (list.size() != 0) {
            this.list.addAll(list);
        }
        adapter.notifyDataSetChanged();
        mRefreshLayout.finishRefresh();
        mRefreshLayout.finishLoadMore();
    }
}
