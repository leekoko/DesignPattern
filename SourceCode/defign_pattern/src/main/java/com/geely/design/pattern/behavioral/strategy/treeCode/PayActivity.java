package com.geely.design.pattern.behavioral.strategy.treeCode;

public class PayActivity {
    private PayStrategy payStrategy;

    public PayActivity(PayStrategy payStrategy){
        this.payStrategy = payStrategy;
    }

    public void executePayStrategy(){
        payStrategy.doPay();
    }
}
