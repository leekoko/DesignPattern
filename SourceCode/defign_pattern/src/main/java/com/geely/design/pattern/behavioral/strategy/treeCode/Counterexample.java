package com.geely.design.pattern.behavioral.strategy.treeCode;

public class Counterexample {

    public static void main(String[] args) {
        doPay("ALI");
    }

    private static void doPay(String type){
        if(type.equals("ALI")){
            System.out.println("使用支付宝支付");
            //其他业务代码
        }else if(type.equals("WECHAT")){
            System.out.println("使用微信支付");
            //其他业务代码
        }else if(type.equals("UNION")){
            System.out.println("使用中国银联支付");
            //其他业务代码
        }

    }

}
