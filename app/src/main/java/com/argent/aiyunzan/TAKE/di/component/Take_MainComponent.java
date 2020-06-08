package com.argent.aiyunzan.TAKE.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.argent.aiyunzan.TAKE.di.module.Take_MainModule;
import com.argent.aiyunzan.TAKE.mvp.contract.Take_MainContract;

import com.jess.arms.di.scope.FragmentScope;
import com.argent.aiyunzan.TAKE.mvp.ui.fragment.Take_MainFragment;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 11:23
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = Take_MainModule.class, dependencies = AppComponent.class)
public interface Take_MainComponent {
    void inject(Take_MainFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Take_MainComponent.Builder view(Take_MainContract.View view);

        Take_MainComponent.Builder appComponent(AppComponent appComponent);

        Take_MainComponent build();
    }
}