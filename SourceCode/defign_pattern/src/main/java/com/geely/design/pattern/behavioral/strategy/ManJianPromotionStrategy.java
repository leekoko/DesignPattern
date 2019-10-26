package com.geely.design.pattern.behavioral.strategy;

public class ManJianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("满减促销，满200减20");
    }
}
