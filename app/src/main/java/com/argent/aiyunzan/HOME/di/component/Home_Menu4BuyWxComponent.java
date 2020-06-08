package com.argent.aiyunzan.HOME.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.argent.aiyunzan.HOME.di.module.Home_Menu4BuyWxModule;
import com.argent.aiyunzan.HOME.mvp.contract.Home_Menu4BuyWxContract;

import com.jess.arms.di.scope.ActivityScope;
import com.argent.aiyunzan.HOME.mvp.ui.activity.Home_Menu4BuyWxActivity;


/**
 * ================================================
 * Date: 05/22/2020 13:13
 * Description:
 * ================================================
 */
@ActivityScope
@Component(modules = Home_Menu4BuyWxModule.class, dependencies = AppComponent.class)
public interface Home_Menu4BuyWxComponent {
    void inject(Home_Menu4BuyWxActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Home_Menu4BuyWxComponent.Builder view(Home_Menu4BuyWxContract.View view);

        Home_Menu4BuyWxComponent.Builder appComponent(AppComponent appComponent);

        Home_Menu4BuyWxComponent build();
    }
}