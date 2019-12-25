# 命令模式   

特点：一般场合中，命令执行是一种紧耦合的关系（例如发起流程）。如果要对命令进行记录、撤销或重做，就变得很麻烦。于是通过将命令封装成对象，可以实现请求者和实现者的松耦合。

缺点：增加类的数量，实现系统复杂度。

核心代码：

命令接口：

```java
public interface Command {
    void execute();
}
```

请求类：

```java
public class CourseVideo {
    private String name;

    public CourseVideo(String name){
        this.name = name;
    }

    public void open(){
        System.out.println(this.name + "课程视频开放");
    }

    public void close(){
        System.out.println(this.name + "课程视频关闭");
    }

}
```

命令对象：

```java
public class OpenCourseVideoCommand implements Command {

    private CourseVideo courseVideo;

    public OpenCourseVideoCommand(CourseVideo courseVideo) {
        this.courseVideo = courseVideo;
    }

    @Override
    public void execute() {
        courseVideo.open();
    }
}
```

```java
public class CloseCourseVideoCommand implements Command {

    private CourseVideo courseVideo;

    public CloseCourseVideoCommand(CourseVideo courseVideo) {
        this.courseVideo = courseVideo;
    }

    @Override
    public void execute() {
        courseVideo.close();
    }
}
```

实现者：

```java
public class Staff {
    private List<Command> commandList = new ArrayList<Command>();

    public void addCommand(Command command){
        commandList.add(command);
    }

    public void executeCommands(){
        for (Command command : commandList) {
            command.execute();
        }
        commandList.clear();
    }

}
```

客户端：

```java
    public static void main(String[] args) {
        CourseVideo courseVideo = new CourseVideo("Java设计模式");
        OpenCourseVideoCommand openCourseVideoCommand = new OpenCourseVideoCommand(courseVideo);
        CloseCourseVideoCommand closeCourseVideoCommand = new CloseCourseVideoCommand(courseVideo);

        Staff staff = new Staff();
        staff.addCommand(openCourseVideoCommand);
        staff.addCommand(closeCourseVideoCommand);

        staff.executeCommands();
    }
```

[源码](..\SourceCode\defign_pattern\src\main\java\com\geely\design\pattern\behavioral\command)    

### 源码解析

Runnable

Junit的framework