package com.argent.aiyunzan.common.model.api;

/**
 * ================================================
 * 存放一些与 API 有关的东西,如请求地址,请求码等
 * <p>
 * Created by MVPArmsTemplate on 12/10/2019 14:09
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public interface Api {

    int SUCCESS = 200;//成功
    int ERROR = 999;//异常

    String APP_DOMAIN = "http://www.yunz99.com/";

    //注册
    String MAIN_REGISTER = "/public/index.php/dm/Login/register";
    //获取手机短信验证码接口
    String MAIN_GETCODE = "/public/index.php/dm/Mobile/Sendsms_code";
    //登录
    String MAIN_LOGIN = "/public/index.php/dm/Login/login";
    //验证码登陆
    String MAIN_AUTHLOGINCODE = "/public/index.php/dm/Login/code_login";
    //找回登录密码
    String MAIN_LOGINFORGETACTIVITY = "/public/index.php/dm/Login/retrieve";


    //首页
    String HOME = "/public/index.php/dm/Homes/index";
    //推广分享二维码接口
    String HOME_MENU3 = "/public/index.php/dm/Ewm/share_ewm";
    //立即购买获取系统金额及限购数量
    String HOME_MENU4HQXTJE = "/public/index.php/dm/Homes/buy_now";
    //立即购买-微信支付接口
    String HOME_MENU4BUYWX = "/public/index.php/dm/Wxpay/weixinapi";
    //立即购买-支付宝支付接口
    String HOME_MENU4BUYZFB = "/public/index.php/dm/Alpay/alipay";
    //客服中心接口
    String HOME_MENU5KFZX1 = "/public/index.php/dm/Homes/service_center";
    //客服中心2接口
    String HOME_MENU5KFZX2 = "/public/index.php/dm/Homes/service_twocenter";
    //新手指引接口
    String HOME_MENU6XSZY = "/public/index.php/dm/Homes/guide";
    //新手指引-详情接口
    String HOME_MENU6XSZYXQ = "/public/index.php/dm/Homes/guide_details";

    //点赞中心-获取数据
    String CENTER_DATA = "/public/index.php/dm/Lighten/get_datas";
    //点赞中心-点击开启机器人自动点赞接口
    String CENTER_START = "/public/index.php/dm/Lighten/load_click";

    //抽奖中心
    String TAKE_DATA = "/public/index.php/dm/Luck/luck_setting";
    //点赞中心-点击轮盘开始抽奖
    String TAKE_START = "/public/index.php/dm/Luck/click_luck";

    //个人中心-首页接口
    String MINE_DATA = "/public/index.php/dm/Index/index";
    //个人中心-我的团队
    String MINE_WDTD = "/public/index.php/dm/Index/myteam";
    //个人中心-我的团队详细接口
    String MINE_TDXQ = "/public/index.php/dm/Index/myteam_detail";
    //个人中心-完善资料(获得用户原始数据)
    String MINE_WSZLHQ = "/public/index.php/dm/Index/improving_data";
    //个人中心-完善资料(提交数据)
    String MINE_WSZLBC = "/public/index.php/dm/Index/submit_data";
    //个人中心-用户头像图片上传接口
    String MINE_TX = "/public/index.php/dm/Update/Update_img";
    //个人中心-收益明细接口
    String MINE_SRMX = "/public/index.php/dm/Index/profit_detail";
    //个人中心-收益明细详情接口
    String MINE_SRMXCLICK = "/public/index.php/dm/Index/details";
    //个人中心-提现记录接口
    String MINE_TXJL = "/public/index.php/dm/Index/werden_log";
    //个人中心-判断是否设置过提现密码及绑定过银行卡返回银行卡绑定信息
    String MINE_YHKXX = "/public/index.php/dm/Index/get_blank";
    //个人中心-绑定银行卡-提交数据
    String MINE_BDYHKTJ = "/public/index.php/dm/Index/submit_blank";
    //个人中心-修改提现密码
    String MINE_TXGM = "/public/index.php/dm/Index/edit_pass";
    //个人中心-我要提现-获取提现数据接口
    String MINE_WYTXHQSJ = "/public/index.php/dm/Index/mywerden";
    //个人中心-我要提现-提现提交接口
    String MINE_WYTXTJ = "/public/index.php/dm/Index/werden_submit";
    //个人中心-版本更新-获取下载地址和版本号接口
    String MINE_BBGX = "/public/index.php/dm/Login/version_number";
}
