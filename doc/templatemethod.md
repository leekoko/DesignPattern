# 模板方法模式

前提摘要：当有一些方法是通用的，可以将其抽取为抽象类的公共方法。

特点：抽象类定义相同的代码，将不同的代码放进不同的子类中，符合开闭原则。

缺点：每个不同的实现都要一个子类来实现，导致类的个数增加，增加系统的复杂度。

核心代码如下：

抽象模板类：

```java
public abstract class ACourse {

    protected final void makeCourse(){
        this.makePPT();
        this.makeVideo();
        if(needWriteArticle()){
            this.writeArticle();
        }
        this.packageCourse();
    }
    //通用的内容添加final写死
    final void makePPT(){
        System.out.println("制作PPT");
    }

    final void makeVideo(){
        System.out.println("制作视频");
    }

    void writeArticle(){
        System.out.println("编写手记");
    }

    //钩子方法
    protected boolean needWriteArticle(){
        return false;
    }

    abstract void packageCourse();
}
```

子类实现：

```java
public class FECourse extends ACourse {
    private boolean needWriteArticleFlag = false;

    @Override
    void packageCourse() {
        System.out.println("提供课程的前端代码");
        System.out.println("提供课程的图片等多媒体");
    }

    public FECourse(boolean needWriteArticleFlag) {
        this.needWriteArticleFlag = needWriteArticleFlag;
    }

    @Override
    protected boolean needWriteArticle() {
        return this.needWriteArticleFlag;
    }
}
```

测试类

```java
        System.out.println("前端课程Start===");
        ACourse feCourse = new FECourse(false);
        feCourse.makeCourse();
        System.out.println("前端课程End===");
```

[源码](..\SourceCode\defign_pattern\src\main\java\com\geely\design\pattern\behavioral\templatemethod)    