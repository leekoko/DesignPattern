package com.geely.design.pattern.behavioral.chainofresponsibility;

public abstract class Approver {
    protected Approver approver;

    public void setNextAoorover(Approver approver){
        this.approver = approver;
    }

    public abstract void deploy(Course course);

}
