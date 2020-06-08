package com.argent.aiyunzan.MAIN.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.argent.aiyunzan.MAIN.di.module.LoginForgetModule;
import com.argent.aiyunzan.MAIN.mvp.contract.LoginForgetContract;

import com.jess.arms.di.scope.ActivityScope;
import com.argent.aiyunzan.MAIN.mvp.ui.activity.LoginForgetActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/30/2020 14:41
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = LoginForgetModule.class, dependencies = AppComponent.class)
public interface LoginForgetComponent {
    void inject(LoginForgetActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        LoginForgetComponent.Builder view(LoginForgetContract.View view);

        LoginForgetComponent.Builder appComponent(AppComponent appComponent);

        LoginForgetComponent build();
    }
}