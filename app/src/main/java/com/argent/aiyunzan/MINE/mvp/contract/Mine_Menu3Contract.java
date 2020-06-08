package com.argent.aiyunzan.MINE.mvp.contract;

import android.widget.EditText;

import com.argent.aiyunzan.common.model.bean.response.LoginGetCodeRsp;
import com.argent.aiyunzan.common.model.bean.response.MineMenu3BdyhkPostDataRsp;
import com.argent.aiyunzan.common.model.bean.response.MineMenu3HqxxRsp;
import com.argent.aiyunzan.common.model.bean.response.MineSyRsp;
import com.argent.aiyunzan.common.widget.CustomEditText;
import com.jess.arms.mvp.IView;
import com.jess.arms.mvp.IModel;

import io.reactivex.Completable;
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
public interface Mine_Menu3Contract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {

        void loadHomeSuccess(MineMenu3HqxxRsp data);
    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model extends IModel {

        Observable<MineMenu3HqxxRsp> loadData();

        Observable<LoginGetCodeRsp> loadGetCode(String et_mobile);

        Observable<MineMenu3BdyhkPostDataRsp> loadPostData(String et_username, String et_card_name,
                                                           String et_card_number,
                                                           String et_mobile,
                                                           String et_verifi,
                                                           String et_pass);
    }
}
