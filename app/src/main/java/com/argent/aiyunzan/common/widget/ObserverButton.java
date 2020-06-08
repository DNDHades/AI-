package com.argent.aiyunzan.common.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yyz on 2018/1/17.
 */

public class ObserverButton extends android.support.v7.widget.AppCompatButton implements TextWatcher {

    private ArrayList<EditText> editTexts;
    private ArrayList<TextView> selectViews;

    public ObserverButton(Context context) {
        this(context, null);
        init();
    }

    public ObserverButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ObserverButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        editTexts = new ArrayList<>();
        selectViews=new ArrayList<>();
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        setEnabled(isSelected()&&checkEmpty());
    }

    public boolean isSelected(){
        boolean isRight=true;
        for (TextView tv : selectViews) {
            if (TextUtils.isEmpty(tv.getText().toString().trim())){
                isRight=false;
                break;
            }
        }
        return isRight;
    }

    private boolean checkEmpty() {
        boolean isRight=true;
        for (EditText et : editTexts) {
            if (TextUtils.isEmpty(et.getText().toString().trim())){
                isRight=false;
                break;
            }
        }

        return isRight;
    }

    public void observerEnable(EditText...ets){
        for (EditText et:ets) {
            et.addTextChangedListener(this);
            editTexts.add(et);
        }
    }

//    public void observerEnable(TextSelectView tv,TextEditView...ets){
//        for (TextEditView et:ets) {
//            et.getEditView().addTextChangedListener(this);
//            editTexts.add(et.getEditView());
//        }
//        tv.getTextView().addTextChangedListener(this);
//        selectViews.add(tv.getTextView());
//    }

//    public void observerEnable(TextSelectView...ets){
//        for (int i = 0; i < ets.length; i++) {
//            TextView tv = ets[i].getTextView();
//            tv.addTextChangedListener(this);
//            selectViews.add(tv);
//        }
//    }


}
