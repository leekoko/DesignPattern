# 观察者模式   

前提摘要：当一个对象状态改变，在解耦的情况下，给依赖对象广播通知。

特点：被观察者类继承Observable类，观察者类实现Observer接口、实现它的update方法，通过调用观察者父类方法实现通知功能。为了防止阻塞，一般采用异步执行。

缺点：过多的细节依赖，可能造成循环依赖。通知所有观察者会花费很多时间。

核心代码如下：

被观察类：

```java
public class Course extends Observable{
    private String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void produceQuestion(Course course, Question question){
        System.out.println(question.getUserName() + "在" + course.courseName+"提交了一个问题");
        setChanged();
        notifyObservers(question);
    }
}
```

观察者类：

```java
public class Teacher implements Observer{
    private String teacherName;

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }


    @Override
    public void update(Observable o, Object arg) {
        Course course = (Course) o;
        Question question = (Question) arg;
        System.out.println(teacherName + "老师的" + course.getCourseName()+"课程接收到一个"+
                question.getUserName()+"提交的问答："+question.getQuestionContent());
    }
}
```

观察者模式实现：

```java
public static void main(String[] args) {
    Course course = new Course("Java设计模式精讲");
    Teacher teacher = new Teacher("Alpha");
    Teacher teacher2 = new Teacher("Beta");
    course.addObserver(teacher);
    course.addObserver(teacher2);

    //业务逻辑代码
    Question question = new Question();
    question.setUserName("Geely");
    question.setQuestionContent("Java的主函数如何编写");
    course.produceQuestion(course, question);
}
```

[源码](..\SourceCode\defign_pattern\src\main\java\com\geely\design\pattern\behavioral\observer)    

### 源码解析

awt的Event

Spring的RequestContextListener

Guava的EventBus  更加便捷

