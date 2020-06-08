package com.argent.aiyunzan.HOME.mvp.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.SpannableString;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.argent.aiyunzan.MyApplication;
import com.argent.aiyunzan.R;
import com.argent.aiyunzan.common.model.bean.info.EmptyInfo;
import com.argent.aiyunzan.common.model.bean.response.HomeMenu4BuyWxRsp;
import com.argent.aiyunzan.common.model.bean.response.HomeMenu4BuyZfbRsp;
import com.argent.aiyunzan.common.model.bean.response.Home_Menu4HqxtjeRps;
import com.argent.aiyunzan.common.model.constant.EventBusTags;
import com.argent.aiyunzan.common.utils.WeiboDialogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.argent.aiyunzan.HOME.di.component.DaggerHome_Menu4Component;
import com.argent.aiyunzan.HOME.mvp.contract.Home_Menu4Contract;
import com.argent.aiyunzan.HOME.mvp.presenter.Home_Menu4Presenter;


import org.simple.eventbus.EventBus;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/30/2020 19:31
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class Home_Menu4Activity extends BaseActivity<Home_Menu4Presenter> implements Home_Menu4Contract.View {

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.tv_price)
    TextView tv_price;
    @BindView(R.id.tv_cost_price)
    TextView tv_cost_price;
    @BindView(R.id.tv_machine_max)
    TextView tv_machine_max;
    @BindView(R.id.tv_sum)
    TextView tv_sum;
    @BindView(R.id.iv_select1)
    ImageView iv_select1;
    @BindView(R.id.iv_select2)
    ImageView iv_select2;
    @BindView(R.id.iv_select3)
    ImageView iv_select3;
    @BindView(R.id.tv_zje)
    TextView tv_zje;
    @BindView(R.id.scrollView)
    ScrollView scrollView;

    private int maxNum = 1;//网络获取的最大值
    private int num = 0;//当前产品的数量
    private double price;
    private Dialog mWeiboDialog;
    private int selectBuy = 1;//0:银行卡,1:支付宝,2:微信

    @OnClick({R.id.tv_add, R.id.tv_low, R.id.ll_select1, R.id.ll_select2,
            R.id.ll_select3, R.id.rl_ljgm})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_add:
                if (num < maxNum) {
                    num += 1;
                    tv_sum.setText(num + "");
                } else {
                    ArmsUtils.makeText(this, "您已经达到购买上限了");
                }
                scalcSum();
                break;
            case R.id.tv_low:
                if (num > 0) {
                    num += -1;
                    tv_sum.setText(num + "");
                }
                scalcSum();
                break;
            case R.id.ll_select1:
                selectBuy = 0;
                unselectAll();
                iv_select1.setSelected(true);
                break;
            case R.id.ll_select2:
                selectBuy = 1;
                unselectAll();
                iv_select2.setSelected(true);
                break;
            case R.id.ll_select3:
                selectBuy = 2;
                unselectAll();
                iv_select3.setSelected(true);
                break;
            case R.id.rl_ljgm:
                loadDataLjgm(num);
                break;
        }
    }

    private void loadDataLjgm(int num) {
        if (num <= 0) {
            ToastUtils.showShort("购买数量不能为0");
            return;
        }
        if (selectBuy == 0) {//银行卡
        } else if (selectBuy == 1) {//支付宝
            mPresenter.loadDataBuyZfb(num);
        } else if (selectBuy == 2) {//微信
            mPresenter.loadDataBuyWx(num);
        }
    }

    private void unselectAll() {
        iv_select1.setSelected(false);
        iv_select2.setSelected(false);
        iv_select3.setSelected(false);

        //滑倒底部
        scrollView.setFocusable(true);
        scrollView.setFocusableInTouchMode(true);
        scrollView.requestFocus();
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }

    private void scalcSum() {
        String sumStr = tv_sum.getText().toString().trim();
        int sum = Integer.valueOf(sumStr);
        double value = sum * price;
        tv_zje.setText("总金额：￥" + value + "");
    }

    @Override
    protected void onResume() {
        super.onResume();
        toolbar_title.setText("立即购买");
    }


    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerHome_Menu4Component //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_home__menu4; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initView();
        mPresenter.loadHqxtjeData();
    }

    private void initView() {
        iv_select2.setSelected(true);
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
    public void loadHqxtjeDataSuccess(Home_Menu4HqxtjeRps datas) {
        Home_Menu4HqxtjeRps.DataBean data = datas.getData();
        maxNum = data.getUse_num();
        tv_machine_max.setText("AI云赞自动点赞系统（限购" + data.getMachine_max() + "台)");
        tv_price.setText("￥" + data.getPrice() + "");
        price = data.getPrice();
        tv_cost_price.setText("原价：￥" + data.getCost_price() + "");
        scalcSum();
    }

    @Override
    public void loadDataBuyWxSuccess(HomeMenu4BuyWxRsp data) {
        Intent intent = new Intent(this, Home_Menu4BuyWxActivity.class);
        intent.putExtra("url", data.getData().getMweb_url());
        intent.putExtra("isZfb", false);
        startActivityForResult(intent, 6666);
    }

    @Override
    public void loadDataBuyZfbSuccess(HomeMenu4BuyZfbRsp data) {
        Log.d(TAG, "loadDataBuyZfbSuccess: " + data.getData().getResult());
        Intent intent = new Intent(this, Home_Menu4BuyWxActivity.class);
        intent.putExtra("url", translation(data.getData().getResult()));
        intent.putExtra("isZfb", true);
        startActivityForResult(intent, 7777);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (data.getStringExtra("result").equals("1")) {//1是支付成功，0是支付失败
                //没做回调
            }
            mPresenter.loadHqxtjeData();
            EventBus.getDefault().post(new EmptyInfo(), EventBusTags.HOME_MENU4ACTIVITY_UPDATE);
        }
    }

    private String translation(String content) {
        String replace = content.replace("&lt;", "<");
        String replace1 = replace.replace("&gt;", ">");
        String replace2 = replace1.replace("&amp;", "&");
        String replace3 = replace2.replace("&quot;", "\"");
        return replace3.replace("&copy;", "©");
    }
}
