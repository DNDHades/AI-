package com.argent.aiyunzan.common.model.bean.response;

/**
 * @author gxc
 * @description:
 * @date : 2020/5/25 19:44
 */
public class HomeMenu4BuyZfbRsp {
    /**
     * code : 200
     * msg : 创建订单成功
     * data : {"result":"&lt;form id='alipaysubmit' name='alipaysubmit' action='https://openapi.alipay.com/gateway.do?charset=UTF-8' method='POST'&gt;&lt;input type='hidden' name='biz_content' value='{&quot;productCode&quot;:&quot;QUICK_WAP_PAY&quot;,&quot;body&quot;:&quot;购买商品下单&quot;,&quot;subject&quot;:&quot;购买商品下单消费&quot;,&quot;out_trade_no&quot;:&quot;ZFB88887202005251029810044949&quot;,&quot;total_amount&quot;:&quot;0.01&quot;,&quot;timeout_express&quot;:&quot;1m&quot;}'/&gt;&lt;input type='hidden' name='app_id' value='2021001157652102'/&gt;&lt;input type='hidden' name='version' value='1.0'/&gt;&lt;input type='hidden' name='format' value='json'/&gt;&lt;input type='hidden' name='sign_type' value='RSA2'/&gt;&lt;input type='hidden' name='method' value='alipay.trade.wap.pay'/&gt;&lt;input type='hidden' name='timestamp' value='2020-05-25 19:43:11'/&gt;&lt;input type='hidden' name='alipay_sdk' value='alipay-sdk-php-20161101'/&gt;&lt;input type='hidden' name='notify_url' value='http://www.yunz99.com/public/index.php/dm/Alnotify/alipay_notify'/&gt;&lt;input type='hidden' name='return_url' value='http://www.yunz99.com/public/index.php/dm/Alnotify/alipay_return'/&gt;&lt;input type='hidden' name='charset' value='UTF-8'/&gt;&lt;input type='hidden' name='sign' value='ICoevpSIIVgf0DmO1RUNPkyC+MuluMfIUrsUvYppWZgELGMPasgt+7mcCFd96TAX45dyAC3F+TtM601p62ZyurDU/gNefJlqW7hBKKx3bTfgxO9hj1xe5uhZB28+A8K0K+Jxw8cb1oDNlEs9dC/wP71m89DsrsoZvuL1p+aHHTRwzhz3tpqFVSrhjywQDaJisne+30X01wFaJUVLcwnbDockUVEorluraKSXsLK1SVNicl+sibRjLpw0jRHId9HDtEQS6LoC86I95Is5SKocFRqN3iUgg8a1pomWPu+twdGbxrtQ+y7zgtP4AysyjXNjHGj0YqT5XzXmH7QBerUotg=='/&gt;&lt;input type='submit' value='ok' style='display:none;''&gt;&lt;/form&gt;&lt;script&gt;document.forms['alipaysubmit'].submit();&lt;/script&gt;"}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * result : &lt;form id='alipaysubmit' name='alipaysubmit' action='https://openapi.alipay.com/gateway.do?charset=UTF-8' method='POST'&gt;&lt;input type='hidden' name='biz_content' value='{&quot;productCode&quot;:&quot;QUICK_WAP_PAY&quot;,&quot;body&quot;:&quot;购买商品下单&quot;,&quot;subject&quot;:&quot;购买商品下单消费&quot;,&quot;out_trade_no&quot;:&quot;ZFB88887202005251029810044949&quot;,&quot;total_amount&quot;:&quot;0.01&quot;,&quot;timeout_express&quot;:&quot;1m&quot;}'/&gt;&lt;input type='hidden' name='app_id' value='2021001157652102'/&gt;&lt;input type='hidden' name='version' value='1.0'/&gt;&lt;input type='hidden' name='format' value='json'/&gt;&lt;input type='hidden' name='sign_type' value='RSA2'/&gt;&lt;input type='hidden' name='method' value='alipay.trade.wap.pay'/&gt;&lt;input type='hidden' name='timestamp' value='2020-05-25 19:43:11'/&gt;&lt;input type='hidden' name='alipay_sdk' value='alipay-sdk-php-20161101'/&gt;&lt;input type='hidden' name='notify_url' value='http://www.yunz99.com/public/index.php/dm/Alnotify/alipay_notify'/&gt;&lt;input type='hidden' name='return_url' value='http://www.yunz99.com/public/index.php/dm/Alnotify/alipay_return'/&gt;&lt;input type='hidden' name='charset' value='UTF-8'/&gt;&lt;input type='hidden' name='sign' value='ICoevpSIIVgf0DmO1RUNPkyC+MuluMfIUrsUvYppWZgELGMPasgt+7mcCFd96TAX45dyAC3F+TtM601p62ZyurDU/gNefJlqW7hBKKx3bTfgxO9hj1xe5uhZB28+A8K0K+Jxw8cb1oDNlEs9dC/wP71m89DsrsoZvuL1p+aHHTRwzhz3tpqFVSrhjywQDaJisne+30X01wFaJUVLcwnbDockUVEorluraKSXsLK1SVNicl+sibRjLpw0jRHId9HDtEQS6LoC86I95Is5SKocFRqN3iUgg8a1pomWPu+twdGbxrtQ+y7zgtP4AysyjXNjHGj0YqT5XzXmH7QBerUotg=='/&gt;&lt;input type='submit' value='ok' style='display:none;''&gt;&lt;/form&gt;&lt;script&gt;document.forms['alipaysubmit'].submit();&lt;/script&gt;
         */

        private String result;

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
}
