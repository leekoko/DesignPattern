package com.geely.design.pattern.structural.composite;

public class Test {
    public static void main(String[] args) {
        CatalogComponent linuxCourse = new Course("linux课程",11);
        CatalogComponent windowsCourse = new Course("Windows课程",21);

        CatalogComponent javaCourseCatalog = new CourseCatalog("Java课程目录",2);
        Course mmailCourse1 = new Course("Java电商一期", 55);
        Course mmailCourse2 = new Course("Java电商二期", 66);
        Course designPattern = new Course("Java设计模式", 77);

        javaCourseCatalog.add(mmailCourse1);
        javaCourseCatalog.add(mmailCourse2);
        javaCourseCatalog.add(designPattern);

        CatalogComponent imoocMainCourseCatalog = new CourseCatalog("慕课网课程主目录",1);
        imoocMainCourseCatalog.add(linuxCourse);
        imoocMainCourseCatalog.add(windowsCourse);
        imoocMainCourseCatalog.add(javaCourseCatalog);

        imoocMainCourseCatalog.print();
    }
}
