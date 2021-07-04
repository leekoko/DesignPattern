package com.geely.design.pattern.behavioral.strategy.treeCode;

public class UnionPayStrategy implements PayStrategy{
    @Override
    public void doPay() {
        System.out.println("使用中国银联支付");
    }
}
