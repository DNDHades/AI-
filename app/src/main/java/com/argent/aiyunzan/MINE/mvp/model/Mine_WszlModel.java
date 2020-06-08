package com.argent.aiyunzan.MINE.mvp.model;

import android.app.Application;
import android.util.Log;

import com.argent.aiyunzan.common.model.api.service.CenterService;
import com.argent.aiyunzan.common.model.api.service.MineService;
import com.argent.aiyunzan.common.model.bean.response.CenterHqsjRsp;
import com.argent.aiyunzan.common.model.bean.response.MineWszlSaveRsp;
import com.argent.aiyunzan.common.model.bean.response.MineWszlTxRsp;
import com.argent.aiyunzan.common.model.bean.response.Mine_WszlHqRsp;
import com.argent.aiyunzan.common.model.constant.ModelInfo;
import com.blankj.utilcode.util.FileUtils;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.argent.aiyunzan.MINE.mvp.contract.Mine_WszlContract;

import java.io.File;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/31/2020 14:32
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
public class Mine_WszlModel extends BaseModel implements Mine_WszlContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public Mine_WszlModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<Mine_WszlHqRsp> loadData() {
        return mRepositoryManager.obtainRetrofitService(MineService.class)
                .load_WszlHq("");
    }

    @Override
    public Observable<MineWszlSaveRsp> loadSave() {
        ModelInfo modelInfo = new ModelInfo();
        String avatar = modelInfo.getAvatar();
        String nickname = modelInfo.getNickname();
        String sex = modelInfo.getSex();
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        builder.addFormDataPart("avatar", avatar);
        builder.addFormDataPart("nickname", nickname);
        builder.addFormDataPart("sex", sex);
        return mRepositoryManager.obtainRetrofitService(MineService.class)
                .load_WszlBc(builder.build());
    }

    @Override
    public Observable<MineWszlSaveRsp> loadTxSave() {
        ModelInfo modelInfo = new ModelInfo();
        String txFile = modelInfo.getTxFile();//文件路径
        File mFile = new File(txFile);//封装为File
        String avatar = modelInfo.getAvatar();
        String nickname = modelInfo.getNickname();
        String sex = modelInfo.getSex();
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        builder.addFormDataPart("avatar", avatar);
        builder.addFormDataPart("nickname", nickname);
        builder.addFormDataPart("sex", sex);
        builder.addPart(
                MultipartBody.Part.createFormData("avatar", mFile.getName(),
                        RequestBody.create(MediaType.parse("image/*"), mFile)));
        return mRepositoryManager.obtainRetrofitService(MineService.class)
                .load_WszlBc(builder.build());
    }

}