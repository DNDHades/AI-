package com.argent.aiyunzan;

import android.content.Context;

import com.blankj.utilcode.util.Utils;
import com.jess.arms.base.BaseApplication;

import update.UpdateAppUtils;

public class MyApplication extends BaseApplication {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        //初始化blankjUtils
        Utils.init(this);

        //初始化版本更新
        UpdateAppUtils.init(this);
    }

    public static Context getContext() {
        return mContext;
    }
}
