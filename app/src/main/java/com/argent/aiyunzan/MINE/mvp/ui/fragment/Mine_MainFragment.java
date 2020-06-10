package com.argent.aiyunzan.MINE.mvp.ui.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.argent.aiyunzan.HOME.mvp.ui.activity.Home_Menu3Activity;
import com.argent.aiyunzan.MAIN.mvp.ui.activity.LoginActivity;
import com.argent.aiyunzan.MINE.di.component.DaggerMine_MainComponent;
import com.argent.aiyunzan.MINE.mvp.contract.Mine_MainContract;
import com.argent.aiyunzan.MINE.mvp.presenter.Mine_MainPresenter;
import com.argent.aiyunzan.MINE.mvp.ui.activity.Mine_Menu1Activity;
import com.argent.aiyunzan.MINE.mvp.ui.activity.Mine_Menu2Activity;
import com.argent.aiyunzan.MINE.mvp.ui.activity.Mine_Menu3Activity;
import com.argent.aiyunzan.MINE.mvp.ui.activity.Mine_Menu4Activity;
import com.argent.aiyunzan.MINE.mvp.ui.activity.Mine_Menu6Activity;
import com.argent.aiyunzan.MINE.mvp.ui.activity.Mine_SrmxActivity;
import com.argent.aiyunzan.MINE.mvp.ui.activity.Mine_TxjlActivity;
import com.argent.aiyunzan.MINE.mvp.ui.activity.Mine_WszlActivity;
import com.argent.aiyunzan.R;
import com.argent.aiyunzan.common.model.bean.info.EmptyInfo;
import com.argent.aiyunzan.common.model.bean.response.MineSyRsp;
import com.argent.aiyunzan.common.model.constant.EventBusTags;
import com.argent.aiyunzan.common.utils.WeiboDialogUtils;
import com.bumptech.glide.Glide;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import org.simple.eventbus.Subscriber;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 13:36
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class Mine_MainFragment extends BaseFragment<Mine_MainPresenter> implements Mine_MainContract.View {

    @BindView(R.id.tv_nickname)
    TextView tv_nickname;
    @BindView(R.id.tv_uid)
    TextView tv_uid;
    @BindView(R.id.tv_fid)
    TextView tv_fid;
    @BindView(R.id.tv_all_shou)
    TextView tv_all_shou;
    @BindView(R.id.tv_level)
    TextView tv_level;
    @BindView(R.id.tv_change)
    TextView tv_change;
    @BindView(R.id.tv_day_shou)
    TextView tv_day_shou;
    @BindView(R.id.tv_werden)
    TextView tv_werden;
    @BindView(R.id.iv_avatar)
    CircleImageView iv_avatar;

    private Dialog mWeiboDialog;

    @OnClick({R.id.ll_menu1, R.id.ll_menu2, R.id.ll_menu3, R.id.ll_menu4, R.id.ll_menu5,
            R.id.ll_menu6, R.id.iv_click1, R.id.iv_click2, R.id.btn_wszl, R.id.rl_srmx,
            R.id.rl_txjl, R.id.btn_out})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_menu1:
                launchActivity(new Intent(getContext(), Mine_Menu1Activity.class));
                break;
            case R.id.ll_menu2:
                launchActivity(new Intent(getContext(), Mine_Menu2Activity.class));
                break;
            case R.id.ll_menu3:
                launchActivity(new Intent(getContext(), Mine_Menu3Activity.class));
                break;
            case R.id.ll_menu4:
                launchActivity(new Intent(getContext(), Mine_Menu4Activity.class));
                break;
            case R.id.ll_menu5:
                launchActivity(new Intent(getContext(), Home_Menu3Activity.class));
                break;
            case R.id.ll_menu6:
                launchActivity(new Intent(getContext(), Mine_Menu6Activity.class));
                break;
            case R.id.iv_click1:
                launchActivity(new Intent(getContext(), Mine_SrmxActivity.class));
                break;
            case R.id.iv_click2:
                launchActivity(new Intent(getContext(), Mine_Menu2Activity.class));
                break;
            case R.id.btn_wszl:
                launchActivity(new Intent(getContext(), Mine_WszlActivity.class));
                break;
            case R.id.rl_srmx:
                launchActivity(new Intent(getContext(), Mine_SrmxActivity.class));
                break;
            case R.id.rl_txjl:
                launchActivity(new Intent(getContext(), Mine_TxjlActivity.class));
                break;
            case R.id.btn_out:
                launchActivity(new Intent(getContext(), LoginActivity.class));
                getActivity().finish();
                break;
        }
    }

    @Subscriber(tag = EventBusTags.ISGHXX)
    void isGhxx(EmptyInfo emptyInfo) {
        mPresenter.loadData();
    }

    public static Mine_MainFragment newInstance() {
        Mine_MainFragment fragment = new Mine_MainFragment();
        return fragment;
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

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerMine_MainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mine__main, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
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
    public void loadHomeSuccess(MineSyRsp datas) {
        MineSyRsp.DataBean data = datas.getData();
        tv_nickname.setText(data.getNickname() + "");
        tv_uid.setText(data.getUid() + "");
        tv_fid.setText(data.getFid() + "");
        tv_all_shou.setText(data.getAll_shou() + "");
        tv_level.setText(data.getLevel() + "");
        tv_change.setText(data.getChange() + "");
        tv_day_shou.setText(data.getDay_shou() + "");
        tv_werden.setText(data.getWerden() + "");
        Glide.with(getContext()).load(data.getAvatar())
                .into(iv_avatar);
    }
}
