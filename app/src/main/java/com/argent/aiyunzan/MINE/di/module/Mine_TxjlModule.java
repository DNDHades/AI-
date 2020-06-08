package com.argent.aiyunzan.MINE.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.argent.aiyunzan.MINE.mvp.contract.Mine_TxjlContract;
import com.argent.aiyunzan.MINE.mvp.model.Mine_TxjlModel;


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
@Module
public abstract class Mine_TxjlModule {

    @Binds
    abstract Mine_TxjlContract.Model bindMine_TxjlModel(Mine_TxjlModel model);
}