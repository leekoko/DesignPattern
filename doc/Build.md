# 建造者模式

## 建造者模式-普通版本

前提摘要：工厂模式创建的对象都是固定的；但如果要创建流程固定、顺序不固定的复杂产品，就需要引入建造者模式。

特点：通过传属性值来构建复杂的对象

缺点：产生多余Builder对象

核心代码如下：

建造者抽象类，定义规则

```java
public abstract class CourseBuilder {

    public abstract void buildCourseName(String courseName);
    public abstract void buildCoursePPT(String coursePPT);
    public abstract void buildCourseVideo(String courseVideo);
    public abstract void buildCourseArtical(String courseArtical);
    public abstract void buildCourseQA(String courseQA);

    public abstract Course makeCourse();
}
```

建造者实现类，组合属性

```java
public class CourseActualBuilder extends CourseBuilder {

    private Course course = new Course();

    @Override
    public void buildCourseName(String courseName) {
        course.setCourseName(courseName);
    }

    @Override
    public void buildCoursePPT(String coursePPT) {
        course.setCoursePPT(coursePPT);
    }

    @Override
    public void buildCourseVideo(String courseVideo) {
        course.setCourseVideo(courseVideo);
    }

    @Override
    public void buildCourseArtical(String courseArtical) {
        course.setCourseArtical(courseArtical);
    }

    @Override
    public void buildCourseQA(String courseQA) {
        course.setCourseQA(courseQA);
    }

    @Override
    public Course makeCourse() {
        return course;
    }
}
```

教练类，负责客户端和建造类关联

```java
public class Coach {
    private CourseBuilder courseBuilder;

    public void setCourseBuilder(CourseBuilder courseBuilder){
        this.courseBuilder = courseBuilder;
    }

    public Course makeCourse(String courseName, String coursePPT,
                             String courseVideo, String courseArticle,
                             String courseQA){
        this.courseBuilder.buildCourseName(courseName);
        this.courseBuilder.buildCoursePPT(coursePPT);
        this.courseBuilder.buildCourseVideo(courseVideo);
        this.courseBuilder.buildCourseArtical(courseArticle);
        this.courseBuilder.buildCourseQA(courseQA);
        return this.courseBuilder.makeCourse();
    }

}
```

客户端使用

```java
        CourseBuilder courseBuilder = new CourseActualBuilder();
        Coach coach = new Coach();
        coach.setCourseBuilder(courseBuilder);
        Course course = coach.makeCourse("Java设计模式精讲", "Java设计模式精讲PPT",
                "Java设计模式精讲视频", "Java设计模式精讲手记",
                "Java设计模式精讲问答");
```

[源码](..\SourceCode\defign_pattern\src\main\java\com\geely\design\pattern\creational\builder)   

## 建造者模式-链式调用版本

前提摘要：普通的建造者模式属性比较多，容易写错。通过链式调用不容易写错

建造者链式调用代码

```java
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
```

代码调用

```java
Course course = new Course.CourseBuilder().buildCourseName("Java设计模式精讲").buildCoursePPT("Java设计模式精讲PPT").buildCourseVideo("Java设计模式精讲视频").build();
```

[源码](..\SourceCode\defign_pattern\src\main\java\com\geely\design\pattern\creational\builder\v2)   

### 源码解析

StringBuilder

Spring的BeanDefinitionBuilder

mybatis的SqlSessionFactoryBuilder,建造者包装的建造者：XMLConfigBuilder

guava的CacheBuilder