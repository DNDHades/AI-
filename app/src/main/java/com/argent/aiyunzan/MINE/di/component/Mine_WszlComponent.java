package com.argent.aiyunzan.MINE.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.argent.aiyunzan.MINE.di.module.Mine_WszlModule;
import com.argent.aiyunzan.MINE.mvp.contract.Mine_WszlContract;

import com.jess.arms.di.scope.ActivityScope;
import com.argent.aiyunzan.MINE.mvp.ui.activity.Mine_WszlActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 14:32
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = Mine_WszlModule.class, dependencies = AppComponent.class)
public interface Mine_WszlComponent {
    void inject(Mine_WszlActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Mine_WszlComponent.Builder view(Mine_WszlContract.View view);

        Mine_WszlComponent.Builder appComponent(AppComponent appComponent);

        Mine_WszlComponent build();
    }
}