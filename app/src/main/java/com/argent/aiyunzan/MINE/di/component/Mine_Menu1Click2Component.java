package com.argent.aiyunzan.MINE.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.argent.aiyunzan.MINE.di.module.Mine_Menu1Click2Module;
import com.argent.aiyunzan.MINE.mvp.contract.Mine_Menu1Click2Contract;

import com.jess.arms.di.scope.ActivityScope;
import com.argent.aiyunzan.MINE.mvp.ui.activity.Mine_Menu1Click2Activity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 04/02/2020 09:56
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = Mine_Menu1Click2Module.class, dependencies = AppComponent.class)
public interface Mine_Menu1Click2Component {
    void inject(Mine_Menu1Click2Activity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Mine_Menu1Click2Component.Builder view(Mine_Menu1Click2Contract.View view);

        Mine_Menu1Click2Component.Builder appComponent(AppComponent appComponent);

        Mine_Menu1Click2Component build();
    }
}