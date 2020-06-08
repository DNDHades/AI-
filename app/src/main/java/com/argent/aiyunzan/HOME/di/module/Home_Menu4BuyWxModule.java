package com.argent.aiyunzan.HOME.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.argent.aiyunzan.HOME.mvp.contract.Home_Menu4BuyWxContract;
import com.argent.aiyunzan.HOME.mvp.model.Home_Menu4BuyWxModel;


/**
 * ================================================
 * Date: 05/22/2020 13:13
 * Description:
 * ================================================
 */
@Module
public abstract class Home_Menu4BuyWxModule {

    @Binds
    abstract Home_Menu4BuyWxContract.Model bindHome_Menu4BuyWxModel(Home_Menu4BuyWxModel model);
}