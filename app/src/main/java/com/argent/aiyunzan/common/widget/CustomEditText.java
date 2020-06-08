package com.argent.aiyunzan.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

/**
 * @author
 * @description: 不可修改但可点击
 * @date : 2020/1/9 16:15
 */
public class CustomEditText extends android.support.v7.widget.AppCompatEditText {
    public CustomEditText(Context context) {
        super(context);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCursorVisible(false);
        setFocusable(false);
        setFocusableInTouchMode(false);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }
}
