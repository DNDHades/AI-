package com.argent.aiyunzan.common.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.argent.aiyunzan.R;

/**
 * @author
 * @description:
 * @date :
 */
public class EdittextDialogUtils {

    private Dialog mDialog;
    private View mView;

    public Dialog showCustomizeDialog(Context mContext, Listener listener) {
        /* @setView 装入自定义View ==> R.layout.dialog_customize
         * 由于dialog_customize.xml只放置了一个EditView，因此和图8一样
         * dialog_customize.xml可自定义更复杂的View
         */
        mDialog = new Dialog(mContext, R.style.Theme_dialog);// 创建自定义样式
        mView = LayoutInflater.from(mContext)
                .inflate(R.layout.custom_edittext_dialog, null);
        EditText et_text = mView.findViewById(R.id.et_text);
        Button btn_confirm = mView.findViewById(R.id.btn_confirm);
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(et_text.getText().toString().trim());
                }
            }
        });
        mDialog.setContentView(mView);
        mDialog.show();
        return mDialog;
    }

    public void cancel(){
        mDialog.cancel();
    }

    public interface Listener {
        void onClick(String text);
    }
}
