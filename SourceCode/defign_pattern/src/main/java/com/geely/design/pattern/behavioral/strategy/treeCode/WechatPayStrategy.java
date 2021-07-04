package com.geely.design.pattern.behavioral.strategy.treeCode;

public class WechatPayStrategy implements PayStrategy{
    @Override
    public void doPay() {
        System.out.println("使用微信支付");
    }
}
