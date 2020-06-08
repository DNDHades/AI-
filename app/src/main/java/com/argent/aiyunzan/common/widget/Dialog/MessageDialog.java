package com.argent.aiyunzan.common.widget.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.argent.aiyunzan.R;
import com.jess.arms.utils.ArmsUtils;

import butterknife.BindAnim;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author gxc
 * @description:
 * @date : 2020/4/20 9:57
 */
public class MessageDialog extends Dialog {

    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_message)
    TextView tv_message;

    private final Context mContext;
    private final View mView;
    private Listener listener;

    @OnClick({R.id.btn_confirm})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm:
                if (listener != null) {
                    listener.onClick();
                }
                cancel();
                break;
        }
    }

    public MessageDialog(Context context, String title, String message) {
        super(context, R.style.My_dialog);
        this.mContext = context;
        mView = LayoutInflater.from(mContext)
                .inflate(R.layout.custom_message_dialog, null,false);
        setContentView(mView);
        ButterKnife.bind(this, mView);
        initView(title, message);
    }

    private void initView(String title, String message) {
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = ArmsUtils.dip2px(mContext,320);//设置Dialog宽度为当前屏幕宽度
//        params.gravity = Gravity.BOTTOM;//设置Dialog在屏幕底部显示
        getWindow().setAttributes(params);//向WindowManager设置属性

        tv_title.setText(title + "");
        tv_message.setText(message + "");
    }

    public void show(Listener listener) {
        this.listener = listener;
        show();
    }

    public interface Listener {
        void onClick();
    }
}
