package com.argent.aiyunzan.MAIN.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.argent.aiyunzan.MAIN.mvp.contract.LoginAuthCodeContract;
import com.argent.aiyunzan.MAIN.mvp.model.LoginAuthCodeModel;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/30/2020 14:24
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
public abstract class LoginAuthCodeModule {

    @Binds
    abstract LoginAuthCodeContract.Model bindLoginAuthCodeModel(LoginAuthCodeModel model);
}