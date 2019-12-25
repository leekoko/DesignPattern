package com.geely.design.pattern.behavioral.chainofresponsibility;

public class Test {
    public static void main(String[] args) {
        ArticleApprover articleApprover = new ArticleApprover();
        VideoApprover videoApprover = new VideoApprover();

        Course course = new Course();
        course.setName("Java设计模式精讲 -- By leekoko");
        course.setArticle("Java设计模式精讲的手记");
        course.setVideo("Java设计模式精讲的视频");

        articleApprover.setNextAoorover(videoApprover);
        articleApprover.deploy(course);
    }

}
