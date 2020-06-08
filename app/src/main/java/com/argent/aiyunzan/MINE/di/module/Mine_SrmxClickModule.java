package com.argent.aiyunzan.MINE.di.module;

import dagger.Binds;
import dagger.Module;

import com.argent.aiyunzan.MINE.mvp.contract.Mine_SrmxClickContract;
import com.argent.aiyunzan.MINE.mvp.model.Mine_SrmxClickModel;


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
@Module
public abstract class Mine_SrmxClickModule {

    @Binds
    abstract Mine_SrmxClickContract.Model bindMine_SrmxClickModel(Mine_SrmxClickModel model);
}