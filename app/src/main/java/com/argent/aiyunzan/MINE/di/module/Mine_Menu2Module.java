package com.argent.aiyunzan.MINE.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.argent.aiyunzan.MINE.mvp.contract.Mine_Menu2Contract;
import com.argent.aiyunzan.MINE.mvp.model.Mine_Menu2Model;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 15:03
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
public abstract class Mine_Menu2Module {

    @Binds
    abstract Mine_Menu2Contract.Model bindMine_Menu2Model(Mine_Menu2Model model);
}