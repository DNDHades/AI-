package com.argent.aiyunzan.AICENTER.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.argent.aiyunzan.AICENTER.di.module.Center_MainModule;
import com.argent.aiyunzan.AICENTER.mvp.contract.Center_MainContract;

import com.jess.arms.di.scope.FragmentScope;
import com.argent.aiyunzan.AICENTER.mvp.ui.fragment.Center_MainFragment;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 10:23
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = Center_MainModule.class, dependencies = AppComponent.class)
public interface Center_MainComponent {
    void inject(Center_MainFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Center_MainComponent.Builder view(Center_MainContract.View view);

        Center_MainComponent.Builder appComponent(AppComponent appComponent);

        Center_MainComponent build();
    }
}