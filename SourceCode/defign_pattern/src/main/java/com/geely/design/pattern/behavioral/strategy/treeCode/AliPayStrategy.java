package com.geely.design.pattern.behavioral.strategy.treeCode;

public class AliPayStrategy implements PayStrategy{
    @Override
    public void doPay() {
        System.out.println("使用支付宝支付");
        //其他业务代码
    }
}
