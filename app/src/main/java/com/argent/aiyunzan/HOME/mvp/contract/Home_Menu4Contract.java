package com.argent.aiyunzan.HOME.mvp.contract;

import com.argent.aiyunzan.common.model.bean.response.HomeMenu4BuyWxRsp;
import com.argent.aiyunzan.common.model.bean.response.HomeMenu4BuyZfbRsp;
import com.argent.aiyunzan.common.model.bean.response.Home_Menu4HqxtjeRps;
import com.jess.arms.mvp.IView;
import com.jess.arms.mvp.IModel;

import io.reactivex.Completable;
import io.reactivex.Observable;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 03/30/2020 19:31
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public interface Home_Menu4Contract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {

        void loadHqxtjeDataSuccess(Home_Menu4HqxtjeRps data);

        void loadDataBuyWxSuccess(HomeMenu4BuyWxRsp data);

        void loadDataBuyZfbSuccess(HomeMenu4BuyZfbRsp data);
    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model extends IModel {

        Observable<Home_Menu4HqxtjeRps> loadHqxtjeData();

        Observable<HomeMenu4BuyWxRsp> loadDataBuyWx(String member);

        Observable<HomeMenu4BuyZfbRsp> loadDataBuyZfb(String s);
    }
}
