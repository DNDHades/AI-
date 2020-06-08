package com.argent.aiyunzan.common.utils;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;

import java.util.List;

/**
 * @author
 * @description:
 * @date : 2019/12/16 17:06
 */
public class OptionsPickerViewUtils {

    private static OptionsPickerViewUtils instance;
    private final Context mContext;
    private OptionsPickerView pvOptions;

    public OptionsPickerViewUtils(Context context) {
        this.mContext = context;
    }

    public static OptionsPickerViewUtils getInstance(Context context){
        if(instance == null){
            synchronized (OptionsPickerViewUtils.class){
                if(instance == null){
                    instance = new OptionsPickerViewUtils(context);
                    return instance;
                }
            }
        }
        return instance;
    }


    public OptionsPickerView show(List<String> str, TextView textView) {
        pvOptions = new OptionsPickerBuilder(mContext, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = str.get(options1);
                textView.setText(tx);
            }
        }).build();
        pvOptions.setPicker(str);
        pvOptions.show();
        return pvOptions;
    }

    public OptionsPickerView show( List<String> str, EditText textView) {
        pvOptions = new OptionsPickerBuilder(mContext, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = str.get(options1);
                textView.setText(tx);
            }
        }).build();
        pvOptions.setPicker(str);
        pvOptions.show();
        return pvOptions;
    }
}
