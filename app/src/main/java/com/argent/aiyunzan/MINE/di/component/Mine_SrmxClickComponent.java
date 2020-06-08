package com.argent.aiyunzan.MINE.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.argent.aiyunzan.MINE.di.module.Mine_SrmxClickModule;
import com.argent.aiyunzan.MINE.mvp.contract.Mine_SrmxClickContract;

import com.jess.arms.di.scope.ActivityScope;
import com.argent.aiyunzan.MINE.mvp.ui.activity.Mine_SrmxClickActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 04/02/2020 15:08
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = Mine_SrmxClickModule.class, dependencies = AppComponent.class)
public interface Mine_SrmxClickComponent {
    void inject(Mine_SrmxClickActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Mine_SrmxClickComponent.Builder view(Mine_SrmxClickContract.View view);

        Mine_SrmxClickComponent.Builder appComponent(AppComponent appComponent);

        Mine_SrmxClickComponent build();
    }
}