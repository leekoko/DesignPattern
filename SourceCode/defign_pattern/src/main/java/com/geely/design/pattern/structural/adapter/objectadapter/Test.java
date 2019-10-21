package com.geely.design.pattern.structural.adapter.objectadapter;


public class Test {
    public static void main(String[] args) {
        ConcreteTarget target = new ConcreteTarget();
        target.request();

        Target adapterTarget = new Adapter();
        adapterTarget.request();
    }
}
