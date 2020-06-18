package com.argent.aiyunzan.HOME.mvp.ui.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.argent.aiyunzan.HOME.di.component.DaggerHome_MainComponent;
import com.argent.aiyunzan.HOME.mvp.contract.Home_MainContract;
import com.argent.aiyunzan.HOME.mvp.presenter.Home_MainPresenter;
import com.argent.aiyunzan.HOME.mvp.ui.activity.Home_Menu1Activity;
import com.argent.aiyunzan.HOME.mvp.ui.activity.Home_Menu2Activity;
import com.argent.aiyunzan.HOME.mvp.ui.activity.Home_Menu3Activity;
import com.argent.aiyunzan.HOME.mvp.ui.activity.Home_Menu4Activity;
import com.argent.aiyunzan.HOME.mvp.ui.activity.Home_Menu5Activity;
import com.argent.aiyunzan.HOME.mvp.ui.activity.Home_Menu6Activity;
import com.argent.aiyunzan.MAIN.mvp.ui.activity.LoginActivity;
import com.argent.aiyunzan.MyApplication;
import com.argent.aiyunzan.R;
import com.argent.aiyunzan.common.model.bean.response.HomeRsp;
import com.argent.aiyunzan.common.model.constant.ModelInfo;
import com.argent.aiyunzan.common.model.constant.SPConstants;
import com.argent.aiyunzan.common.utils.WeiboDialogUtils;
import com.argent.aiyunzan.common.widget.AutoPollRecyclerView.AutoPollAdapter;
import com.argent.aiyunzan.common.widget.AutoPollRecyclerView.AutoPollRecyclerView;
import com.argent.aiyunzan.common.widget.Dialog.MessageDialog;
import com.blankj.utilcode.util.SPUtils;
import com.bumptech.glide.Glide;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoaderInterface;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/30/2020 15:10
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class Home_MainFragment extends BaseFragment<Home_MainPresenter> implements Home_MainContract.View {

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.rv_content)
    AutoPollRecyclerView rv_content;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.tv_note)
    TextView tv_note;
    @BindView(R.id.sy_smartRefreshlayout)
    SmartRefreshLayout sySmartRefreshlayout;
    Unbinder unbinder;

    private List<String> imageUrls = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private Dialog mWeiboDialog;
    private String level;

    @OnClick({R.id.ll_menu1, R.id.ll_menu2, R.id.ll_menu3, R.id.ll_menu4, R.id.ll_menu5, R.id.ll_menu6,
            R.id.tv_note})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_menu1:
                launchActivity(new Intent(getContext(), Home_Menu1Activity.class));
                break;
            case R.id.ll_menu2:
                launchActivity(new Intent(getContext(), Home_Menu2Activity.class));
                break;
            case R.id.ll_menu3:
                ModelInfo modelInfo = new ModelInfo();
                level = modelInfo.getLevel();
                if (level.equals("0")) {
                    Toast.makeText(mContext, "您还没有开通AI系统哦!", Toast.LENGTH_SHORT).show();
                } else {
                    launchActivity(new Intent(getContext(), Home_Menu3Activity.class));
                }

                break;
            case R.id.ll_menu4:
                launchActivity(new Intent(getContext(), Home_Menu4Activity.class));
                break;
            case R.id.ll_menu5:
                launchActivity(new Intent(getContext(), Home_Menu5Activity.class));
                break;
            case R.id.ll_menu6:
                launchActivity(new Intent(getContext(), Home_Menu6Activity.class));
                break;
            case R.id.tv_note:
                new MessageDialog(getContext(), "公告",
                        tv_note.getText().toString()).show();
                break;
        }
    }

    @Override
    public void onDestroy() {
        if (null != rv_content) {
            rv_content.stop();
        }
        super.onDestroy();
    }

    public static Home_MainFragment newInstance() {
        Home_MainFragment fragment = new Home_MainFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerHome_MainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home__main, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initView();
        loadHome();
        initListenr();
    }

    private void initListenr() {
        sySmartRefreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPresenter.loadHome();
            }
        });
    }

    private void loadHome() {
        mPresenter.loadHome();
    }

    private void initView() {
        tv_note.setSelected(true);
        initBanner();
    }

    private void initRecyclerView(List<String> titles) {
        rv_content.setHasFixedSize(true);
        rv_content.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_content.setAdapter(new AutoPollAdapter(titles));
        rv_content.start();
    }

    private void initBanner() {
        banner.setImageLoader(new ImageLoaderInterface() {
            @Override
            public void displayImage(Context context, Object path, View imageView) {
                Glide.with(context).load(path).into((ImageView) imageView);
            }

            @Override
            public View createImageView(Context context) {
                return null;
            }
        });
        //设置图片集合
        banner.setImages(imageUrls);
        //设置轮播时间
        banner.setDelayTime(2500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //设置样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
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
    public void loadHomeSuccess(HomeRsp data) {
        //banner
        List<String> picarr = data.getData().getPicarr();
        banner.update(picarr);
        tv_note.setText(data.getData().getNote() + "");
        SPUtils.getInstance().put(SPConstants.LEVEL, data.getData().getLevel() + "");
        level = data.getData().getLevel() + "";
        //下面轮播
        List<HomeRsp.DataBean.ArrayBean> array = data.getData().getArray();
        for (HomeRsp.DataBean.ArrayBean aArrayBean : array) {
            String str = "ID" + aArrayBean.getMember() + "号已购买了" +
                    aArrayBean.getNum() + "台分布式工作中......";
            titles.add(str);
        }

        initRecyclerView(titles);
        sySmartRefreshlayout.finishRefresh();
    }

    @Override
    public void loadHomeError(HomeRsp data) {
        ArmsUtils.makeText(MyApplication.getContext(), data.getMsg() + "");
        launchActivity(new Intent(getContext(),
                LoginActivity.class));
        ((Activity) getContext()).finish();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
