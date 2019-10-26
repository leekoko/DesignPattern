package com.geely.design.pattern.structural.adapter.classadapter;

public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        //适配方法，转化新增功能
        super.adapteeRequest();
    }
}
