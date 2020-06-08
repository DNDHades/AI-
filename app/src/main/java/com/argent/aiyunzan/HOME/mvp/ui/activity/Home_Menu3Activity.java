package com.argent.aiyunzan.HOME.mvp.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.argent.aiyunzan.HOME.di.component.DaggerHome_Menu3Component;
import com.argent.aiyunzan.R;
import com.argent.aiyunzan.common.model.bean.response.Home_Menu3Rsp;
import com.argent.aiyunzan.common.model.constant.ModelInfo;
import com.argent.aiyunzan.common.utils.CommonUtils;
import com.argent.aiyunzan.common.utils.SaveImageToGalleryUtils;
import com.argent.aiyunzan.common.utils.WeiboDialogUtils;
import com.bumptech.glide.Glide;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.argent.aiyunzan.HOME.mvp.contract.Home_Menu3Contract;
import com.argent.aiyunzan.HOME.mvp.presenter.Home_Menu3Presenter;



import butterknife.BindView;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 09:19
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class Home_Menu3Activity extends BaseActivity<Home_Menu3Presenter> implements Home_Menu3Contract.View {

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.iv_qrcode)
    ImageView iv_qrcode;
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
    @BindView(R.id.rl_photo)
    RelativeLayout rl_photo;

    private Dialog mWeiboDialog;

    @OnClick({R.id.tv_click})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_click:
                Bitmap mBitmap = CommonUtils.getViewBp(rl_photo);
                if (mBitmap != null) {
                    SaveImageToGalleryUtils.saveImage(this, mBitmap);
                } else {
                    ArmsUtils.makeText(this, "保存失败");
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        toolbar_title.setText("推广二维码");
    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerHome_Menu3Component //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_home__menu3; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initView();
        mPresenter.loadData();
    }

    private void initView() {
        ModelInfo modelInfo = new ModelInfo();
        String uid = modelInfo.getUid();
        tv_1.setText(uid.charAt(0) + "");
        tv_2.setText(uid.charAt(1) + "");
        tv_3.setText(uid.charAt(2) + "");
        tv_4.setText(uid.charAt(3) + "");
        tv_5.setText(uid.charAt(4) + "");
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
    public void loadHomeSuccess(Home_Menu3Rsp data) {
        Glide.with(this).load(data.getData().getImgs()).into(iv_qrcode);
    }

}
