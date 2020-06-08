package com.argent.aiyunzan.HOME.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.argent.aiyunzan.HOME.di.module.Home_Menu6Module;
import com.argent.aiyunzan.HOME.mvp.contract.Home_Menu6Contract;

import com.jess.arms.di.scope.ActivityScope;
import com.argent.aiyunzan.HOME.mvp.ui.activity.Home_Menu6Activity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 09:16
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = Home_Menu6Module.class, dependencies = AppComponent.class)
public interface Home_Menu6Component {
    void inject(Home_Menu6Activity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Home_Menu6Component.Builder view(Home_Menu6Contract.View view);

        Home_Menu6Component.Builder appComponent(AppComponent appComponent);

        Home_Menu6Component build();
    }
}