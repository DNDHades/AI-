package com.argent.aiyunzan.HOME.di.module;

import dagger.Binds;
import dagger.Module;

import com.argent.aiyunzan.HOME.mvp.contract.Home_Menu3Contract;
import com.argent.aiyunzan.HOME.mvp.model.Home_Menu3Model;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 09:19
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
public abstract class Home_Menu3Module {

    @Binds
    abstract Home_Menu3Contract.Model bindHome_menu3Model(Home_Menu3Model model);
}