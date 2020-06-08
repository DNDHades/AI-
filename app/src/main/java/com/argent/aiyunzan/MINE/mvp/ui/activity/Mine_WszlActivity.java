package com.argent.aiyunzan.MINE.mvp.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.argent.aiyunzan.MAIN.mvp.ui.activity.LoginActivity;
import com.argent.aiyunzan.MyApplication;
import com.argent.aiyunzan.R;
import com.argent.aiyunzan.common.model.bean.info.EmptyInfo;
import com.argent.aiyunzan.common.model.bean.response.MineWszlSaveRsp;
import com.argent.aiyunzan.common.model.bean.response.MineWszlTxRsp;
import com.argent.aiyunzan.common.model.bean.response.Mine_WszlHqRsp;
import com.argent.aiyunzan.common.model.constant.Constants;
import com.argent.aiyunzan.common.model.constant.EventBusTags;
import com.argent.aiyunzan.common.model.constant.SPConstants;
import com.argent.aiyunzan.common.utils.PictureSelectorUtils;
import com.argent.aiyunzan.common.utils.WeiboDialogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.bumptech.glide.Glide;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.argent.aiyunzan.MINE.di.component.DaggerMine_WszlComponent;
import com.argent.aiyunzan.MINE.mvp.contract.Mine_WszlContract;
import com.argent.aiyunzan.MINE.mvp.presenter.Mine_WszlPresenter;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;


import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 14:32
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class Mine_WszlActivity extends BaseActivity<Mine_WszlPresenter> implements Mine_WszlContract.View {

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.rg_sex)
    RadioGroup rg_sex;
    @BindView(R.id.rb_nan)
    RadioButton rb_nan;
    @BindView(R.id.rb_nv)
    RadioButton rb_nv;
    @BindView(R.id.iv_avatars)
    CircleImageView iv_avatars;
    @BindView(R.id.tv_uid)
    TextView tv_uid;
    @BindView(R.id.et_nickname)
    EditText et_nickname;

    private Dialog mWeiboDialog;
    private final int REQUESTCODE = 6666;
    private int sex = 1;
    private boolean isTx;//有无上传头像

    @OnClick({R.id.btn_save, R.id.iv_avatars})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_save:
                if (!TextUtils.isEmpty(getText(et_nickname))) {
                    SPUtils.getInstance().put(SPConstants.NICKNAME, getText(et_nickname) + "");
                    SPUtils.getInstance().put(SPConstants.SEX, sex + "");
                    if(isTx){
                        mPresenter.loadTxSave();
                    }else{
                        mPresenter.loadSave();
                    }
                } else {
                    ArmsUtils.makeText(MyApplication.getContext(), "昵称不能为空");
                }
                break;
            case R.id.iv_avatars:
                new PictureSelectorUtils().show(Mine_WszlActivity.this, REQUESTCODE, 1);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        toolbar_title.setText("完善资料");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUESTCODE:
                    //.getPath()为原图path
                    //.getCutPath()为裁剪后path，需判断media.isCut();是否为true
                    //.getCompressPath()为压缩后的path
                    SPUtils.getInstance().put(SPConstants.TXFILE,
                            PictureSelector.obtainMultipleResult(data).get(0).getCompressPath() + "");
                    isTx = true;
                    Glide.with(Mine_WszlActivity.this).load(PictureSelector.
                            obtainMultipleResult(data).get(0).getCompressPath()).into(iv_avatars);
                    break;
            }
        }
    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMine_WszlComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_mine__wszl; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initListener();
        mPresenter.loadData();
    }

    private void initListener() {
        rg_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_nan:
                        sex = 1;
                        break;
                    case R.id.rb_nv:
                        sex = 2;
                        break;
                }
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
    public void loadDataSuccess(Mine_WszlHqRsp datas) {
        Mine_WszlHqRsp.DataBean data = datas.getData();
        SPUtils.getInstance().put(SPConstants.AVATAR, data.getAvatar() + "");

        Glide.with(this).load(data.getAvatars()).into(iv_avatars);
        tv_uid.setText(data.getUid() + "");
        et_nickname.setText(data.getNickname() + "");

        if (data.getSex() == 1) {//男
            rb_nan.setChecked(true);
            sex = 1;
        } else {//女
            rb_nv.setChecked(true);
            sex = 2;
        }
    }

    @Override
    public void loadSaveSuccess(MineWszlSaveRsp data) {
        EventBus.getDefault().post(new EmptyInfo(), EventBusTags.ISGHXX);
        killMyself();
    }


}
