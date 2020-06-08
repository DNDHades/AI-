package com.argent.aiyunzan.MINE.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.argent.aiyunzan.MINE.di.module.Mine_TxjlModule;
import com.argent.aiyunzan.MINE.mvp.contract.Mine_TxjlContract;

import com.jess.arms.di.scope.ActivityScope;
import com.argent.aiyunzan.MINE.mvp.ui.activity.Mine_TxjlActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 17:18
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = Mine_TxjlModule.class, dependencies = AppComponent.class)
public interface Mine_TxjlComponent {
    void inject(Mine_TxjlActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Mine_TxjlComponent.Builder view(Mine_TxjlContract.View view);

        Mine_TxjlComponent.Builder appComponent(AppComponent appComponent);

        Mine_TxjlComponent build();
    }
}