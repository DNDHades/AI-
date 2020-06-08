package com.argent.aiyunzan.MAIN.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.argent.aiyunzan.MAIN.di.module.LoginAuthCodeModule;
import com.argent.aiyunzan.MAIN.mvp.contract.LoginAuthCodeContract;

import com.jess.arms.di.scope.ActivityScope;
import com.argent.aiyunzan.MAIN.mvp.ui.activity.LoginAuthCodeActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/30/2020 14:24
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = LoginAuthCodeModule.class, dependencies = AppComponent.class)
public interface LoginAuthCodeComponent {
    void inject(LoginAuthCodeActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        LoginAuthCodeComponent.Builder view(LoginAuthCodeContract.View view);

        LoginAuthCodeComponent.Builder appComponent(AppComponent appComponent);

        LoginAuthCodeComponent build();
    }
}