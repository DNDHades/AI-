package com.argent.aiyunzan.MAIN.di.module;

import android.support.v4.app.FragmentActivity;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.jess.arms.di.scope.ActivityScope;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.argent.aiyunzan.MAIN.mvp.contract.MainContract;
import com.argent.aiyunzan.MAIN.mvp.model.MainModel;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 12/10/2019 14:13
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
public abstract class MainModule {

    @Binds
    abstract MainContract.Model bindMainModel(MainModel model);

    @ActivityScope
    @Provides
    static RxPermissions provideRxPermissions(MainContract.View view){
        return new RxPermissions((FragmentActivity) view.getActivity());
    }
}