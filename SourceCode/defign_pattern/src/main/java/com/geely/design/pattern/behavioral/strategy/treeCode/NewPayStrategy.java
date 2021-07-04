package com.geely.design.pattern.behavioral.strategy.treeCode;

public class NewPayStrategy implements PayStrategy{
    @Override
    public void doPay() {
        System.out.println("使用新方式支付");
    }
}
