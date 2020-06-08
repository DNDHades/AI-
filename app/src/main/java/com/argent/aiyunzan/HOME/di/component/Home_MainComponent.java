package com.argent.aiyunzan.HOME.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.argent.aiyunzan.HOME.di.module.Home_MainModule;
import com.argent.aiyunzan.HOME.mvp.contract.Home_MainContract;

import com.jess.arms.di.scope.FragmentScope;
import com.argent.aiyunzan.HOME.mvp.ui.fragment.Home_MainFragment;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/30/2020 15:10
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = Home_MainModule.class, dependencies = AppComponent.class)
public interface Home_MainComponent {
    void inject(Home_MainFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Home_MainComponent.Builder view(Home_MainContract.View view);

        Home_MainComponent.Builder appComponent(AppComponent appComponent);

        Home_MainComponent build();
    }
}