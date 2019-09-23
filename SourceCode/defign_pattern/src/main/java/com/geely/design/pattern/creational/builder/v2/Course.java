package com.geely.design.pattern.creational.builder.v2;

import com.geely.design.pattern.creational.builder.CourseBuilder;

/**
 * 演进版    链式调用
 */
public class Course {
    private String courseName;
    private String coursePPT;
    private String courseVideo;
    private String courseArtical;

    private String courseQA;

    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", coursePPT='" + coursePPT + '\'' +
                ", courseVideo='" + courseVideo + '\'' +
                ", courseArtical='" + courseArtical + '\'' +
                ", courseQA='" + courseQA + '\'' +
                '}';
    }

    public Course(CourseBuilder courseBuilder){
        this.courseName = courseBuilder.courseName;
        this.coursePPT = courseBuilder.coursePPT;
        this.courseVideo = courseBuilder.courseVideo;
        this.courseArtical = courseBuilder.courseArtical;
        this.courseQA = courseBuilder.courseQA;
    }

    public static class CourseBuilder{
        private String courseName;
        private String coursePPT;
        private String courseVideo;
        private String courseArtical;

        private String courseQA;

        public CourseBuilder buildCourseName(String courseName) {
            this.courseName = courseName;
            return this;
        }

        public CourseBuilder buildCoursePPT(String coursePPT) {
            this.coursePPT = coursePPT;
            return this;
        }


        public CourseBuilder buildCourseVideo(String courseVideo) {
            this.courseVideo = courseVideo;
            return this;
        }


        public CourseBuilder buildCourseArtical(String courseArtical) {
            this.courseArtical = courseArtical;
            return this;
        }


        public CourseBuilder buildCourseQA(String courseQA) {
            this.courseQA = courseQA;
            return this;
        }

        public Course build() {
            return new Course(this);
        }

    }







}
