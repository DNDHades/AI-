package com.argent.aiyunzan.HOME.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.argent.aiyunzan.HOME.di.module.Home_Menu3Module;
import com.argent.aiyunzan.HOME.mvp.contract.Home_Menu3Contract;

import com.jess.arms.di.scope.ActivityScope;
import com.argent.aiyunzan.HOME.mvp.ui.activity.Home_Menu3Activity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 09:19
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = Home_Menu3Module.class, dependencies = AppComponent.class)
public interface Home_Menu3Component {
    void inject(Home_Menu3Activity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Home_Menu3Component.Builder view(Home_Menu3Contract.View view);

        Home_Menu3Component.Builder appComponent(AppComponent appComponent);

        Home_Menu3Component build();
    }
}