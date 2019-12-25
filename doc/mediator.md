# 中介者模式    

特点：对象之间的通讯，可能会产生大量的关联关系。通过中介者模式可以进行解耦，形成星型结构。

缺点：导致系统复杂

核心代码：

中介者类：

```java
public class ChatRoom {
    public static void showMessage(User user, String message){
        System.out.println(new Date().toString()
                + " [" + user.getName() +"] : " + message);
    }
}
```

user类：

```java
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name){
        this.name  = name;
    }

    public void sendMessage(String message){
        ChatRoom.showMessage(this,message);
    }
}
```

测试类：

```java
public class MediatorPatternDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
```

[源码](..\SourceCode\defign_pattern\src\main\java\com\geely\design\pattern\behavioral\mediator)    

### 源码解析    

Timer -- sched()

