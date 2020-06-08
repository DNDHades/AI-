package com.argent.aiyunzan.HOME.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.argent.aiyunzan.HOME.mvp.contract.Home_Menu5Click1Contract;
import com.argent.aiyunzan.HOME.mvp.model.Home_Menu5Click1Model;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 09:10
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
public abstract class Home_Menu5Click1Module {

    @Binds
    abstract Home_Menu5Click1Contract.Model bindHome_Menu5Click1Model(Home_Menu5Click1Model model);
}