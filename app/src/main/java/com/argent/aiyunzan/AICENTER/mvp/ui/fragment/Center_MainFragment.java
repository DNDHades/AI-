package com.argent.aiyunzan.AICENTER.mvp.ui.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.argent.aiyunzan.HOME.mvp.ui.activity.Home_Menu3Activity;
import com.argent.aiyunzan.HOME.mvp.ui.activity.Home_Menu4Activity;
import com.argent.aiyunzan.MyApplication;
import com.argent.aiyunzan.R;
import com.argent.aiyunzan.common.model.api.Api;
import com.argent.aiyunzan.common.model.bean.info.EmptyInfo;
import com.argent.aiyunzan.common.model.bean.response.CenterHqsjRsp;
import com.argent.aiyunzan.common.model.bean.response.CenterStartRsp;
import com.argent.aiyunzan.common.model.constant.EventBusTags;
import com.argent.aiyunzan.common.model.constant.ModelInfo;
import com.argent.aiyunzan.common.utils.WeiboDialogUtils;
import com.argent.aiyunzan.common.widget.Dialog.MessageDialog;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.argent.aiyunzan.AICENTER.di.component.DaggerCenter_MainComponent;
import com.argent.aiyunzan.AICENTER.mvp.contract.Center_MainContract;
import com.argent.aiyunzan.AICENTER.mvp.presenter.Center_MainPresenter;


import org.simple.eventbus.Subscriber;

import butterknife.BindView;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 10:23
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class Center_MainFragment extends BaseFragment<Center_MainPresenter> implements Center_MainContract.View {

    @BindView(R.id.tv_level)
    TextView tv_level;
    @BindView(R.id.tv_click_num)
    TextView tv_click_num;
    @BindView(R.id.tv_money)
    TextView tv_money;
    @BindView(R.id.iv_click)
    ImageView iv_click;
    @BindView(R.id.iv_runbottom)
    ImageView iv_runbottom;
    @BindView(R.id.iv_runtop)
    ImageView iv_runtop;

    private Dialog mWeiboDialog;
    private String level;

    @OnClick({R.id.iv_click, R.id.rl_fxm,R.id.tv_czsm,R.id.iv_ljgm})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_click:
                mPresenter.loadStart();
                break;
            case R.id.rl_fxm:
                ModelInfo modelInfo = new ModelInfo();
                level = modelInfo.getLevel();
                if (level.equals("0")) {
                    Toast.makeText(mContext, "您还没有开通AI系统哦!", Toast.LENGTH_SHORT).show();
                } else {
                    launchActivity(new Intent(getContext(), Home_Menu3Activity.class));
                }
                break;
            case R.id.tv_czsm:
                new MessageDialog(getContext(), "操作说明",
                        "1、点击最下方红色立即购买完成支付动作!\n" +
                                "2、返回点赞中心点击红色开始按钮系统开始自动工作!\n" +
                                "3、一天只需要点击一次开始按钮无需其他操作!\n" +
                                "4、购买系统台数越多，赚佣也越多，限购10台!").show();
                break;
            case R.id.iv_ljgm:
                launchActivity(new Intent(getContext(), Home_Menu4Activity.class));
                break;
        }
    }

    @Subscriber(tag = EventBusTags.HOME_MENU4ACTIVITY_UPDATE)
    void updateUI(EmptyInfo emptyInfo){
        mPresenter.loadData();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            //相当于Fragment的onResume
            mPresenter.loadData();
        } else {
            //相当于Fragment的onPause
        }
    }

    public static Center_MainFragment newInstance() {
        Center_MainFragment fragment = new Center_MainFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerCenter_MainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_center__main, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }

    private void jumpDouyin() {
        String url = "snssdk1128://aweme/detail/6818397331076025604?refer=web&gd_label=click_wap_detail_download_feature&appParam=%7B%22__type__%22%3A%22wap%22%2C%22position%22%3A%22900718067%22%2C%22parent_group_id%22%3A%226553813763982626051%22%2C%22webid%22%3A%226568996356873356814%22%2C%22gd_label%22%3A%22click_wap%22%7D&needlaunchlog=1";
        try {
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
            getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过此方法可以使 Fragment 能够与外界做一些交互和通信, 比如说外部的 Activity 想让自己持有的某个 Fragment 对象执行一些方法,
     * 建议在有多个需要与外界交互的方法时, 统一传 {@link Message}, 通过 what 字段来区分不同的方法, 在 {@link #setData(Object)}
     * 方法中就可以 {@code switch} 做不同的操作, 这样就可以用统一的入口方法做多个不同的操作, 可以起到分发的作用
     * <p>
     * 调用此方法时请注意调用时 Fragment 的生命周期, 如果调用 {@link #setData(Object)} 方法时 {@link Fragment#onCreate(Bundle)} 还没执行
     * 但在 {@link #setData(Object)} 里却调用了 Presenter 的方法, 是会报空的, 因为 Dagger 注入是在 {@link Fragment#onCreate(Bundle)} 方法中执行的
     * 然后才创建的 Presenter, 如果要做一些初始化操作,可以不必让外部调用 {@link #setData(Object)}, 在 {@link #initData(Bundle)} 中初始化就可以了
     * <p>
     * Example usage:
     * <pre>
     * public void setData(@Nullable Object data) {
     *     if (data != null && data instanceof Message) {
     *         switch (((Message) data).what) {
     *             case 0:
     *                 loadData(((Message) data).arg1);
     *                 break;
     *             case 1:
     *                 refreshUI();
     *                 break;
     *             default:
     *                 //do something
     *                 break;
     *         }
     *     }
     * }
     *
     * // call setData(Object):
     * Message data = new Message();
     * data.what = 0;
     * data.arg1 = 1;
     * fragment.setData(data);
     * </pre>
     *
     * @param data 当不需要参数时 {@code data} 可以为 {@code null}
     */
    @Override
    public void setData(@Nullable Object data) {

    }

    @Override
    public void showLoading() {
        mWeiboDialog = WeiboDialogUtils.createLoadingDialog(getContext(), "加载中...");
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

    }

    @Override
    public void loadHomeSuccess(CenterHqsjRsp datas) {
        CenterHqsjRsp.DataBean data = datas.getData();
        tv_level.setText(data.getLevel() + "台");
        tv_click_num.setText(data.getClick_num() + "次");
        tv_money.setText(data.getMoney() + "元");
        if (data.getStatus() == 0) {
            iv_click.setVisibility(View.VISIBLE);
            iv_runbottom.setVisibility(View.VISIBLE);
            iv_runtop.setVisibility(View.GONE);
            Glide.with(getContext()).load(R.drawable.center_main_no_14).into(iv_runbottom);
        } else {
            iv_click.setVisibility(View.GONE);
            iv_runbottom.setVisibility(View.VISIBLE);
            iv_runtop.setVisibility(View.VISIBLE);
            Glide.with(getContext()).load(R.drawable.center_main_14).into(iv_runbottom);
            Glide.with(getContext()).load(R.drawable.f).into(iv_runtop);
        }
    }

    @Override
    public void loadStartSuccess(CenterStartRsp data) {
        if(data.getCode() == 200){
            mPresenter.loadStartSuccessData();
        }
        ArmsUtils.makeText(MyApplication.getContext(), data.getMsg());
    }

    @Override
    public void loadStartSuccessData(CenterHqsjRsp datas) {
        CenterHqsjRsp.DataBean data = datas.getData();
        tv_level.setText(data.getLevel() + "台");
        tv_click_num.setText(data.getClick_num() + "次");
        tv_money.setText(data.getMoney() + "元");
        if (data.getStatus() == 0) {
            iv_click.setVisibility(View.VISIBLE);
            iv_runbottom.setVisibility(View.GONE);
            iv_runtop.setVisibility(View.GONE);
        } else {
            iv_click.setVisibility(View.GONE);
            iv_runbottom.setVisibility(View.VISIBLE);
            iv_runtop.setVisibility(View.VISIBLE);
            Glide.with(getContext()).load(R.drawable.center_main_14).into(iv_runbottom);
            Glide.with(getContext()).load(R.drawable.f).into(iv_runtop);
        }

    }

}
