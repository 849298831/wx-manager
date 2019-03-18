package com.example.manager.wxmanager.common.winxin;

public class WxConfig {
    //#小程序ID
    public static String appId="wx19bc7a411c3a3104";
      // #小程序密钥
    public static String secret="d2786f0ed6fc10b08d3ab31cc5cf01c1";
           //  商户号
    public static String mchId="1503119261";
           //  #支付签名
    public static String paySignKey="";
           // #交易类型
    public static String tradeType="JSAPI";
          //#证书名称，对应不同的商户号
    public static String certName="/cert/apiclient_cert.p12";
           //#支付回调地址
    public static String notifyUrl="https://www.fly2you.cn/admin/url/api/notify";
           // #获取code的请求地址
    public static String getCode="https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=STAT#wechat_redirect";
          //  #获取Web_access_tokenhttps的请求地址
    public static String webAccessTokenhttps = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
           // #拉取用户信息的请求地址
    public static String userMessage="https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";
            //#微信统一下单接口路径
    public static String uniformorder="https://api.mch.weixin.qq.com/pay/unifiedorder";
           // #退款地址
    public static String refundUrl="https://api.mch.weixin.qq.com/secapi/pay/refund";
            //#退款查询地址
    public static String refundqueryUrl="https://api.mch.weixin.qq.com/pay/refundquery";
           // #微信查询订单状态
    public static String orderquery="https://api.mch.weixin.qq.com/pay/orderquery";







}
