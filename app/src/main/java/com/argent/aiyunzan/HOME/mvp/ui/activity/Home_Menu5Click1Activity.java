package com.argent.aiyunzan.HOME.mvp.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.argent.aiyunzan.R;
import com.argent.aiyunzan.common.model.bean.response.HomeMenu5Kfzx2Rsp;
import com.argent.aiyunzan.common.utils.SaveImageToGalleryUtils;
import com.argent.aiyunzan.common.utils.WeiboDialogUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.argent.aiyunzan.HOME.di.component.DaggerHome_Menu5Click1Component;
import com.argent.aiyunzan.HOME.mvp.contract.Home_Menu5Click1Contract;
import com.argent.aiyunzan.HOME.mvp.presenter.Home_Menu5Click1Presenter;


import butterknife.BindView;

import static com.argent.aiyunzan.MyApplication.getContext;
import static com.jess.arms.utils.Preconditions.checkArgument;
import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 09:10
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class Home_Menu5Click1Activity extends BaseActivity<Home_Menu5Click1Presenter> implements Home_Menu5Click1Contract.View {

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.iv_wxcode)
    ImageView iv_wxcode;
    @BindView(R.id.tv_wxnumber)
    TextView tv_wxnumber;

    private Bitmap mBitmap = null;
    private Dialog mWeiboDialog;

    @Override
    protected void onResume() {
        super.onResume();
        toolbar_title.setText("客服中心");
    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerHome_Menu5Click1Component //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_home__menu5_click1; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initListener();
        mPresenter.loadKfzx2Data();
    }

    private void initListener() {
        iv_wxcode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mBitmap != null) {
                    SaveImageToGalleryUtils.saveImage(getContext(), mBitmap);
                } else {
                    ArmsUtils.makeText(getContext(), "当前没有图片");
                }
                return true;
            }
        });
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
    public void loadHomeSuccess(HomeMenu5Kfzx2Rsp datas) {
        HomeMenu5Kfzx2Rsp.DataBean data = datas.getData();
        Glide.with(this).load(data.getWxewm()).into(iv_wxcode);
        tv_wxnumber.setText("微信客服："+data.getWxnumber() + "");

        Glide.with(this)
                .asBitmap()
                .load(data.getWxewm())
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        mBitmap = resource;
                    }
                });

    }

}
