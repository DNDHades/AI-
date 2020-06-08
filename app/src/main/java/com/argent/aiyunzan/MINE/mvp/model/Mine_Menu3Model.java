package com.argent.aiyunzan.MINE.mvp.model;

import android.app.Application;
import android.widget.EditText;

import com.argent.aiyunzan.common.model.api.service.MainService;
import com.argent.aiyunzan.common.model.api.service.MineService;
import com.argent.aiyunzan.common.model.bean.response.LoginGetCodeRsp;
import com.argent.aiyunzan.common.model.bean.response.MineMenu3BdyhkPostDataRsp;
import com.argent.aiyunzan.common.model.bean.response.MineMenu3HqxxRsp;
import com.argent.aiyunzan.common.widget.CustomEditText;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.argent.aiyunzan.MINE.mvp.contract.Mine_Menu3Contract;

import io.reactivex.Observable;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 15:19
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
public class Mine_Menu3Model extends BaseModel implements Mine_Menu3Contract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public Mine_Menu3Model(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<MineMenu3HqxxRsp> loadData() {
        return mRepositoryManager.obtainRetrofitService(MineService.class)
                .load_Hqyhkxx("");
    }

    @Override
    public Observable<LoginGetCodeRsp> loadGetCode(String et_mobile) {
        return mRepositoryManager.obtainRetrofitService(MainService.class)
                .main_getCode(et_mobile);
    }

    @Override
    public Observable<MineMenu3BdyhkPostDataRsp> loadPostData(String et_username, String et_card_name,
                                                              String et_card_number,
                                                              String et_mobile,
                                                              String et_verifi,
                                                              String et_pass) {
        return mRepositoryManager.obtainRetrofitService(MineService.class)
                .load_Bdyhktj(et_username, et_card_name,
                        et_card_number, et_mobile, et_verifi, et_pass);
    }
}