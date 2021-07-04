package com.geely.design.pattern.behavioral.strategy.treeCode;

public class Test {

    public static void main(String[] args) {
        String payKey = "ALI";
        PayActivity payActivity = new PayActivity(PayStrategyFactory.getStrategy(payKey));
        payActivity.executePayStrategy();
    }
}
