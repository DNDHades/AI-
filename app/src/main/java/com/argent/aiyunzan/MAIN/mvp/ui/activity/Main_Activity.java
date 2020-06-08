package com.argent.aiyunzan.MAIN.mvp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.argent.aiyunzan.AICENTER.mvp.ui.fragment.Center_MainFragment;
import com.argent.aiyunzan.HOME.mvp.ui.fragment.Home_MainFragment;
import com.argent.aiyunzan.MAIN.di.component.DaggerMainComponent;
import com.argent.aiyunzan.MINE.mvp.ui.fragment.Mine_MainFragment;
import com.argent.aiyunzan.MyApplication;
import com.argent.aiyunzan.R;
import com.argent.aiyunzan.TAKE.mvp.ui.fragment.Take_MainFragment;
import com.argent.aiyunzan.common.adapter.CommonViewPagerAdapter;
import com.argent.aiyunzan.common.model.bean.info.EmptyInfo;
import com.argent.aiyunzan.common.model.bean.response.ErrorRps;
import com.argent.aiyunzan.common.model.constant.EventBusTags;
import com.argent.aiyunzan.common.model.constant.SPConstants;
import com.argent.aiyunzan.common.widget.NotScrollCustomViewPager;
import com.blankj.utilcode.util.SPUtils;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.EventBusManager;
import com.jess.arms.utils.ArmsUtils;

import com.argent.aiyunzan.MAIN.mvp.contract.MainContract;
import com.argent.aiyunzan.MAIN.mvp.presenter.MainPresenter;


import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 12/10/2019 14:13
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class Main_Activity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.viewpager)
    NotScrollCustomViewPager mViewpager;
    @BindView(R.id.iv_menu_1)
    ImageView iv_menu_1;
    @BindView(R.id.tv_menu_1)
    TextView tv_menu_1;
    @BindView(R.id.iv_menu_2)
    ImageView iv_menu_2;
    @BindView(R.id.tv_menu_2)
    TextView tv_menu_2;
    @BindView(R.id.iv_menu_3)
    ImageView iv_menu_3;
    @BindView(R.id.tv_menu_3)
    TextView tv_menu_3;
    @BindView(R.id.iv_menu_4)
    ImageView iv_menu_4;
    @BindView(R.id.tv_menu_4)
    TextView tv_menu_4;

    private List<Fragment> mPagerFragment = new ArrayList<>();
    private boolean isBack = true;
    private int page = 0;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isBack = true;
        }
    };

    @Subscriber(tag = EventBusTags.ISLOADCODE999)
    void isLoadCode999(ErrorRps errorRps) {
        ArmsUtils.makeText(MyApplication.getContext(), errorRps.getMsg());
        SPUtils.getInstance().remove(SPConstants.TOKEN);
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        launchActivity(intent);
        killMyself();
    }

    @OnClick({R.id.ll_menu1, R.id.ll_menu2, R.id.ll_menu3, R.id.ll_menu4})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_menu1:
                page = 0;
                jumpPager(page);
                break;
            case R.id.ll_menu2:
                page = 1;
                jumpPager(page);
                break;
            case R.id.ll_menu3:
                page = 2;
                jumpPager(page);
                break;
            case R.id.ll_menu4:
                page = 3;
                jumpPager(page);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_BACK) {
            if (isBack) {
                isBack = false;
                handler.sendEmptyMessageDelayed(0, 2000);
                ArmsUtils.makeText(this, "再按一次退出");
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initView();
        jumpPager(0);
    }

    private void initView() {
        mPresenter.requestPermission(getActivity());
        SPUtils.getInstance().put(SPConstants.ISLOGIN, true);

        mPagerFragment.add(Home_MainFragment.newInstance());
        mPagerFragment.add(Center_MainFragment.newInstance());
        mPagerFragment.add(Take_MainFragment.newInstance());
        mPagerFragment.add(Mine_MainFragment.newInstance());
        mViewpager.setOffscreenPageLimit(4);
        mViewpager.setAdapter(new CommonViewPagerAdapter(getSupportFragmentManager(), mPagerFragment));
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

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
    public Activity getActivity() {
        return this;
    }

    public void jumpPager(int page) {
        unselectViewAll();
        mViewpager.setCurrentItem(page);
        switch (page) {
            case 0:
                iv_menu_1.setSelected(true);
                tv_menu_1.setTextColor(getResources().getColor(R.color.color_menu_select));
                break;
            case 1:
                iv_menu_2.setSelected(true);
                tv_menu_2.setTextColor(getResources().getColor(R.color.color_menu_select));
                break;
            case 2:
                iv_menu_3.setSelected(true);
                tv_menu_3.setTextColor(getResources().getColor(R.color.color_menu_select));
                break;
            case 3:
                iv_menu_4.setSelected(true);
                tv_menu_4.setTextColor(getResources().getColor(R.color.color_menu_select));
                break;
        }
    }

    private void unselectViewAll() {
        iv_menu_1.setSelected(false);
        tv_menu_1.setTextColor(getResources().getColor(R.color.color_menu_unselect));
        iv_menu_2.setSelected(false);
        tv_menu_2.setTextColor(getResources().getColor(R.color.color_menu_unselect));
        iv_menu_3.setSelected(false);
        tv_menu_3.setTextColor(getResources().getColor(R.color.color_menu_unselect));
        iv_menu_4.setSelected(false);
        tv_menu_4.setTextColor(getResources().getColor(R.color.color_menu_unselect));
    }

}
