# 责任链模式

特点：为请求创建此次请求的链，请求的发送者与多个接收者解耦，某个接收者若不能处理请求，就传给下个接收者。用于过滤消息进行处理的场景。    

缺点：链条过长，影响性能

核心代码：

记录器抽象：

```java
public abstract class Approver {
    protected Approver approver;

    public void setNextAoorover(Approver approver){
        this.approver = approver;
    }

    public abstract void deploy(Course course);

}
```

扩展记录器的审批类：

```java
public class ArticleApprover extends Approver {
    @Override
    public void deploy(Course course) {
        if(StringUtils.isNoneEmpty(course.getArticle())){
            System.out.println(course.getName() + "含有手记，批准");
            if(approver != null){
                approver.deploy(course);
            }
        }else {
            System.out.println(course.getName() + "不包含手记，不批准，流程结束");
            return;
        }
    }
}
```

```java
public class VideoApprover extends Approver {
    @Override
    public void deploy(Course course) {
        if(StringUtils.isNoneEmpty(course.getVideo())){
            System.out.println(course.getName() + "含有视频，批准");
            if(approver != null){
                approver.deploy(course);
            }
        }else {
            System.out.println(course.getName() + "不包含视频，不批准，流程结束");
            return;
        }
    }
}
```

测试类：设置记录器的下个节点，传入处理对象

```java
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
```

[源码](..\SourceCode\defign_pattern\src\main\java\com\geely\design\pattern\behavioral\chainofresponsibility)     

### 源码解析

LoggerContextFilter -- doFilter

