package com.argent.aiyunzan.HOME.mvp.ui.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;


import com.argent.aiyunzan.R;
import com.blankj.utilcode.util.ToastUtils;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.argent.aiyunzan.HOME.di.component.DaggerHome_Menu4BuyWxComponent;
import com.argent.aiyunzan.HOME.mvp.contract.Home_Menu4BuyWxContract;
import com.argent.aiyunzan.HOME.mvp.presenter.Home_Menu4BuyWxPresenter;
import com.luck.picture.lib.tools.Constant;


import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Date: 05/22/2020 13:13
 * Description:
 * ================================================
 */

public class Home_Menu4BuyWxActivity extends BaseActivity<Home_Menu4BuyWxPresenter> implements Home_Menu4BuyWxContract.View {

//    @BindView(R.id.fl_container)
//    FrameLayout fl_container;
    @BindView(R.id.web)
    WebView mWebView;

//    private WebView mWebView;
    private WebViewClient webViewClient;
    boolean firstVisitWXH5PayUrl = true;
    private String mReffer = "http://www.yunz99.com";
    private boolean fristGoTo;
    private boolean isZfb;

    @Override
    protected void onDestroy() {
//        destroyWebView();
        super.onDestroy();
    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerHome_Menu4BuyWxComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_home__menu4_buy_wx; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        isZfb = getIntent().getBooleanExtra("isZfb", false);
        //获取数据
        initWebViewClient();
        initView(getIntent().getStringExtra("url"));
    }

    private void initWebViewClient() {
        webViewClient = new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                if (url.startsWith("weixin://")) {
                    try {
                        fristGoTo = true;
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                        return true;
                    } catch (Exception e) {
                        // 防止手机没有安装处理某个 scheme 开头的 url 的 APP 导致 crash
                        ToastUtils.showShort("该手机没有安装微信");
                        return true;
                    }
                } else if (url.startsWith("alipays://") || url.startsWith("alipay")) {
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                        return true;
                    } catch (Exception e) {
                        // 防止手机没有安装处理某个 scheme 开头的 url 的 APP 导致 crash
                        // 启动支付宝 App 失败，会自行跳转支付宝网页支付
                        return true;
                    }
                }

                // 处理普通 http 请求跳转
                if (!(url.startsWith("http") || url.startsWith("https"))) {
                    return true;
                }

                // 处理微信 H5 支付跳转时验证请求头 referer 失效
                // 验证不通过会出现“商家参数格式有误，请联系商家解决”
                if (url.contains("wx.tenpay.com")) {

                    // 申请微信 H5 支付时填写的域名
                    // 比如经常用来测试网络连通性的 http://www.baidu.com
                    String referer = "http://www.yunz99.com";

                    // 兼容 Android 4.4.3 和 4.4.4 两个系统版本设置 referer 无效的问题
                    if (("4.4.3".equals(android.os.Build.VERSION.RELEASE))
                            || ("4.4.4".equals(android.os.Build.VERSION.RELEASE))) {
                        if (firstVisitWXH5PayUrl) {
                            view.loadDataWithBaseURL(referer, "<script>window.location.href=\"" + url + "\";</script>",
                                    "text/html", "utf-8", null);
                            // 修改标记位状态，避免循环调用
                            // 再次进入微信H5支付流程时记得重置状态 firstVisitWXH5PayUrl = true
                            firstVisitWXH5PayUrl = false;
                        }
                        // 返回 false 由系统 WebView 自己处理该 url
                        return false;
                    } else {
                        // HashMap 指定容量初始化，避免不必要的内存消耗
                        HashMap<String, String> map = new HashMap<>(1);
                        map.put("Referer", referer);
                        view.loadUrl(url, map);
                        return true;
                    }
                }
                return false;
            }

        };
    }

    @SuppressLint("SetJavaScriptEnabled")
    public void initView(String url) {
        mWebView = new WebView(getApplicationContext());
//        fl_container.addView(mWebView);
        // 让WebView能够执行javaScript
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setDefaultTextEncodingName("UTF-8");
        mWebView.getSettings().setAllowContentAccess(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        mWebView.addJavascriptInterface(new JsInterface(this), "JSBridge");
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.setWebViewClient(webViewClient);

//        if (mWebView.isHardwareAccelerated()) mWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);

        if (isZfb) {
            mWebView.loadData(url, "text/html;charset=utf-8", "utf-8");
        } else {
            HashMap<String, String> map = new HashMap<>(1);
            map.put("Referer", mReffer);
            mWebView.loadUrl(url, map);
        }
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

    private void destroyWebView() {
//        fl_container.removeAllViews();
        if (mWebView != null) {
            mWebView.clearHistory();
            mWebView.clearCache(true);
            mWebView.loadUrl("about:blank"); // clearView() should be changed to loadUrl("about:blank"), since clearView() isdeprecated now
            mWebView.freeMemory();
            mWebView.pauseTimers();
            mWebView = null; // Note that mWebView.destroy() and mWebView = null do the exact same thing
        }
    }

    // 设置回退监听
    // 5、覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if (mWebView.canGoBack()) {
                mWebView.goBack(); //goBack()表示返回WebView的上一页面
                return true;
            } else {
                finish();
                return true;
            }
        }
        return false;
    }

    public class JsInterface {

        Context context;

        public JsInterface(Context context) {
            this.context = context;
        }

        @JavascriptInterface
        public void wechatPayRes(String object) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    callBackResult(object);
                }
            });
        }
    }

    public void callBackResult(String result) {
        Intent intent = new Intent();
        intent.putExtra("result", result);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (fristGoTo && !isZfb) {//微信
            callBackResult("");
        }
    }
}
