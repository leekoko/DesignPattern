package com.geely.design.pattern.behavioral.templatemethod;

public class Test {
    public static void main(String[] args) {
        System.out.println("设计模式Start===");
        ACourse designPatternCourse = new DesignPatternCourse();
        designPatternCourse.makeCourse();
        System.out.println("设计模式End===");

        System.out.println("前端课程Start===");
        ACourse feCourse = new FECourse(false);
        feCourse.makeCourse();
        System.out.println("前端课程End===");

    }
}
