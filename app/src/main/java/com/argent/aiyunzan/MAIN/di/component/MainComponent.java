package com.argent.aiyunzan.MAIN.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.argent.aiyunzan.MAIN.mvp.ui.activity.Main_Activity;
import com.jess.arms.di.component.AppComponent;

import com.argent.aiyunzan.MAIN.di.module.MainModule;
import com.argent.aiyunzan.MAIN.mvp.contract.MainContract;

import com.jess.arms.di.scope.ActivityScope;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 12/10/2019 14:13
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(Main_Activity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        MainComponent.Builder view(MainContract.View view);

        MainComponent.Builder appComponent(AppComponent appComponent);

        MainComponent build();
    }
}