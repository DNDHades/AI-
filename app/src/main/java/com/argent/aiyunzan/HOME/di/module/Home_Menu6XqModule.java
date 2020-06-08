package com.argent.aiyunzan.HOME.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.argent.aiyunzan.HOME.mvp.contract.Home_Menu6XqContract;
import com.argent.aiyunzan.HOME.mvp.model.Home_Menu6XqModel;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 04/01/2020 17:29
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
public abstract class Home_Menu6XqModule {

    @Binds
    abstract Home_Menu6XqContract.Model bindHome_Menu6XqModel(Home_Menu6XqModel model);
}