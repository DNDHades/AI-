package com.argent.aiyunzan.common.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.argent.aiyunzan.R;

public class JcgxDialog {

    private Dialog mDialog;
    private View mView;
    private String number;

    public JcgxDialog(String number) {
        this.number = number;
    }

    public Dialog showCustomizeDialog(Context mContext, Listener listener) {
        /* @setView 装入自定义View ==> R.layout.dialog_customize
         * 由于dialog_customize.xml只放置了一个EditView，因此和图8一样
         * dialog_customize.xml可自定义更复杂的View
         */
        mDialog = new Dialog(mContext, R.style.Theme_dialog);// 创建自定义样式
        mDialog.setCancelable(false);
        mDialog.setCanceledOnTouchOutside(false);
        mView = LayoutInflater.from(mContext)
                .inflate(R.layout.jcgx_dialog, null);
        Button btn_confirm = mView.findViewById(R.id.btn_confirm);
        TextView textView = mView.findViewById(R.id.tv_bbh);
        textView.setText("有新的版本" + "(" + number + ")");
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick();
                }
            }
        });
        mDialog.setContentView(mView);
        mDialog.show();
        return mDialog;
    }

    public void cancel() {
        mDialog.cancel();
    }

    public interface Listener {
        void onClick();
    }

}
