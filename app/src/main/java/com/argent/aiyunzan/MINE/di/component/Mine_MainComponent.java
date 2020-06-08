package com.argent.aiyunzan.MINE.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.argent.aiyunzan.MINE.di.module.Mine_MainModule;
import com.argent.aiyunzan.MINE.mvp.contract.Mine_MainContract;

import com.jess.arms.di.scope.FragmentScope;
import com.argent.aiyunzan.MINE.mvp.ui.fragment.Mine_MainFragment;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 13:36
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = Mine_MainModule.class, dependencies = AppComponent.class)
public interface Mine_MainComponent {
    void inject(Mine_MainFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Mine_MainComponent.Builder view(Mine_MainContract.View view);

        Mine_MainComponent.Builder appComponent(AppComponent appComponent);

        Mine_MainComponent build();
    }
}