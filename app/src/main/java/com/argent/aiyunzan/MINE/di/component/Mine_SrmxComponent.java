package com.argent.aiyunzan.MINE.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.argent.aiyunzan.MINE.di.module.Mine_SrmxModule;
import com.argent.aiyunzan.MINE.mvp.contract.Mine_SrmxContract;

import com.jess.arms.di.scope.ActivityScope;
import com.argent.aiyunzan.MINE.mvp.ui.activity.Mine_SrmxActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 17:00
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = Mine_SrmxModule.class, dependencies = AppComponent.class)
public interface Mine_SrmxComponent {
    void inject(Mine_SrmxActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Mine_SrmxComponent.Builder view(Mine_SrmxContract.View view);

        Mine_SrmxComponent.Builder appComponent(AppComponent appComponent);

        Mine_SrmxComponent build();
    }
}