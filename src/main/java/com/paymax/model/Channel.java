package com.paymax.model;

/**
 * @author wangoo
 * @since 2017-11-24 09:34
 */
public enum Channel {

    alipay_app("支付宝移动支付"),

    wechat_app("微信移动支付"),

    applepayapp("Apple Pay"),

    wechat_wap("微信公众号"),

    wechat_csb("微信公众号C2B扫描支付"),

    alipay_web("支付宝即时到账"),

    lakala_web("拉卡拉PC网关"),

    lakalawebfast("拉卡拉PC快捷支付"),

    lakala_app("拉卡拉移动支付"),

    lakala_h5("拉卡拉H5支付");

    Channel(String desc) {
        this.desc = desc;
    }

    private String desc;

    public String getDesc() {
        return desc;
    }
}
