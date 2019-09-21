package com.geely.design.pattern.creational.factorymethod;

public class FEVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制FEVideo课程视频");
    }
}
