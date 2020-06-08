package com.argent.aiyunzan.TAKE.mvp.ui.fragment;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.argent.aiyunzan.MAIN.mvp.ui.activity.Main_Activity;
import com.argent.aiyunzan.MINE.mvp.ui.activity.Mine_Menu1Activity;
import com.argent.aiyunzan.MyApplication;
import com.argent.aiyunzan.R;
import com.argent.aiyunzan.common.model.api.Api;
import com.argent.aiyunzan.common.model.bean.response.TakeHqCjgzDataRsp;
import com.argent.aiyunzan.common.model.bean.response.TakeStartRsp;
import com.argent.aiyunzan.common.utils.WeiboDialogUtils;
import com.argent.aiyunzan.common.widget.PieView;
import com.argent.aiyunzan.common.widget.luckpan.LuckPan;
import com.argent.aiyunzan.common.widget.luckpan.LuckPanAnimEndCallBack;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.argent.aiyunzan.TAKE.di.component.DaggerTake_MainComponent;
import com.argent.aiyunzan.TAKE.mvp.contract.Take_MainContract;
import com.argent.aiyunzan.TAKE.mvp.presenter.Take_MainPresenter;


import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 11:23
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class Take_MainFragment extends BaseFragment<Take_MainPresenter> implements Take_MainContract.View {

    @BindView(R.id.lp_pan)
    LuckPan lp_pan;
    @BindView(R.id.iv_take)
    ImageView iv_take;
    @BindView(R.id.tv_time)
    TextView tv_time;
    @BindView(R.id.tv_share_num)
    TextView tv_share_num;

    private Dialog mWeiboDialog;
    private String[] mItemStrs = {"988元", "8.8元", "28元", "68元", "88元",
            "288元", "688元", "888元"};

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @OnClick({R.id.iv_take, R.id.tv_wdtd})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_take:
                mPresenter.loadStart();
                break;
            case R.id.tv_wdtd:
                launchActivity(new Intent(getContext(), Mine_Menu1Activity.class));
                break;
        }
    }

    public static Take_MainFragment newInstance() {
        Take_MainFragment fragment = new Take_MainFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerTake_MainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_take__main, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initView();
        mPresenter.loadData();
    }

    private void initView() {
        lp_pan.setItems(mItemStrs);
        lp_pan.setLuckNumber(0);
        lp_pan.setLuckPanAnimEndCallBack(new LuckPanAnimEndCallBack() {
            @Override
            public void onAnimEnd(String str) {//转完以后
                Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
            }
        });
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
    public void loadHomeSuccess(TakeHqCjgzDataRsp data) {
        tv_share_num.setText("一、直推" + data.getData().getShare_num() + "人可获得抽奖机会：");
        tv_time.setText("三、活动时间：" + data.getData().getShare_time() + "截止");
    }

    @Override
    public void loadStartSuccess(TakeStartRsp data) {
        ArmsUtils.makeText(MyApplication.getContext(), data.getMsg());
        if (data.getCode() == Api.SUCCESS) {
            if (data.getData() == null) {
                return;
            }
            String money;
            money = "68";
            money = data.getData().getMoney();
            switch (money) {
                case "888":
                    lp_pan.setLuckNumber(0);
                    break;
                case "988":
                    lp_pan.setLuckNumber(1);
                    break;
                case "8.8":
                    lp_pan.setLuckNumber(2);
                    break;
                case "28":
                    lp_pan.setLuckNumber(3);
                    break;
                case "68":
                    lp_pan.setLuckNumber(4);
                    break;
                case "88":
                    lp_pan.setLuckNumber(5);
                    break;
                case "288":
                    lp_pan.setLuckNumber(6);
                    break;
                case "688":
                    lp_pan.setLuckNumber(7);
                    break;
            }
            lp_pan.startAnim();
        }
    }
}
