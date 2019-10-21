package com.geely.design.pattern.structural.adapter.objectadapter;

import com.geely.design.pattern.structural.adapter.classadapter.Target;

public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("ConcreteTarget目标方法");
    }
}
