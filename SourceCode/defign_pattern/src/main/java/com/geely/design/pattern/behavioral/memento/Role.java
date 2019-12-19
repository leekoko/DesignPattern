package com.geely.design.pattern.behavioral.memento;

public class Role {
    private int bloodFlow;
    private int magicPoint;

    public Role(int bloodFlow,int magicPoint){
        this.bloodFlow = bloodFlow;
        this.magicPoint = magicPoint;
    }

    public int getBloodFlow() {
        return bloodFlow;
    }

    public void setBloodFlow(int bloodFlow) {
        this.bloodFlow = bloodFlow;
    }

    public int getMagicPoint() {
        return magicPoint;
    }

    public void setMagicPoint(int magicPoint) {
        this.magicPoint = magicPoint;
    }

    /**
     * @desc 展示角色当前状态
     * @return void
     */
    public void display(){
        System.out.println("用户当前状态:");
        System.out.println("血量:" + getBloodFlow() + ";蓝量:" + getMagicPoint());
    }

    /**
     * @desc 保持存档、当前状态
     * @return
     * @return Memento
     */
    public Memento saveMemento(){
        return new Memento(getBloodFlow(), getMagicPoint());
    }

    /**
     * @desc 恢复存档
     * @param memento
     * @return void
     */
    public void restoreMemento(Memento memento){
        this.bloodFlow = memento.getBloodFlow();
        this.magicPoint = memento.getMagicPoint();
    }
}
