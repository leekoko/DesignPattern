# 工厂模式   

## 0.简单工厂模式

前题摘要：简单工厂模式是一种编码习惯，不属于23种设计模式之一。

特点：通过传参的方式来获取相应对象，不需要关心引入包等创建类的操作。

缺点：简单工厂模式违背了开闭原则，工程类内容的扩展会影响其他功能的使用，扩展性不好。通过将简单工厂修改为反射方式，可以弥补扩展性不足。

核心代码如下：

```java
public class VideoFactory {

    public Video getVideo(Class c){
        Video video = null;
        try {
            video = (Video) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return video;
    }


/*    public Video getVideo(String type){
        //最简单工厂模式
        if("java".equalsIgnoreCase(type)){
            return new JavaVideo();
        }else if("python".equalsIgnoreCase(type)){
            return new PythonVideo();
        }
        return null;

    }*/

}
```

[源码](..\SourceCode\defign_pattern\src\main\java\com\geely\design\pattern\creational\simplefactory)

### 源码解析

new Calendar();  》 createCalendar();

Class.forName();

LoggerFactory.getLogger();

## 1.工厂方法模式

前提摘要：工厂方法是简单工厂的演进

特点：工厂方法就是在简单工厂模式上添加：子类指定创建哪个对象

缺点：增加类的个数，增加系统抽象性、理解难度

工厂类只定义规则

```java
public abstract class VideoFactory {  //也可以用interface，但抽象方法可能有已知方法
    //将创捷对象的职能移交到子类
    public abstract Video getVideo(); 
}
```

子类创建对象

```java
public class JavaVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }
}
```

client调用时还是无需关系创建对象细节

```java
VideoFactory videoFactory = new JavaVideoFactory();
Video video = videoFactory.getVideo();
video.produce();
```

[源码](..\SourceCode\defign_pattern\src\main\java\com\geely\design\pattern\creational\factorymethod)  

### 源码解析  

Collection的iterator方法，ArrayList实现

URLStreamHandlerFactory的createURLStreamHandler方法，Launcher实现

ILoggerFactory的getLogger方法

## 2.抽象工厂模式

M：抽象工厂模式和普通工厂模式有什么关系吗？

Z：抽象工厂模式是工厂方法模式的升级版本，工厂方法模式提供的所有产品都是衍生自同一个接口或抽象类，而抽象工厂模式所提供的产品则是衍生自不同的接口或抽象类。  

M：那怎么选择使用抽象工厂模式或者普通工厂模式呢？

Z：在使用的时候无需在意属于哪个模式，而是要注意当方法共用时，应提取为接口。这就自动形成不同接口下的产品族。这就形成了抽象工厂模式。

如下代码：

```java
    interface IProduct1 {
        public void show();
    }
    interface IProduct2 {
        public void show();
    }

    class Product1 implements IProduct1 {
        public void show() {
            System.out.println("这是1型产品");
        }
    }
    class Product2 implements IProduct2 {
        public void show() {
            System.out.println("这是2型产品");
        }
    }

    interface IFactory {
        public IProduct1 createProduct1();
        public IProduct2 createProduct2();
    }
    class Factory implements IFactory{
        public IProduct1 createProduct1() {
            return new Product1();
        }
        public IProduct2 createProduct2() {
            return new Product2();
        }
    }

    public class Client {
        public static void main(String[] args){
            IFactory factory = new Factory();
            factory.createProduct1().show();
            factory.createProduct2().show();
        }
    }
```

M：总结一下，抽象工厂模式就是在兼顾工厂模式的前提下，尽量实现接口提取。工厂模式的原则为：提供被实例化的类的时候，尽量利用工厂类做到封装，便于解耦和简单调用。

