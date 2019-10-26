package com.geely.design.pattern.behavioral.strategy;

public class FanXianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现，返回的金额存放到慕课网余额");
    }
}
