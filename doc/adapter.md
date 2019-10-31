# 适配器模式

前提摘要：当业务开发后需求变更，导致旧接口和新开发的接口不适配。为了把多类接口放在一起使用，可以用到适配器模式。

缺点：Java不支持多继承，不能适配多个类。

## 类适配器模式

通过类继承来实现适配器功能

核心代码：

适配者类

```java
public class Adaptee {
    public void adapteeRequest(){
        System.out.println("被适配者的方法");
    }
}
```

目标方法接口

```java
public interface Target {
    void request();
}
```

适配器类

```java
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        //将被适配方法进行适配的逻辑
        super.adapteeRequest();
    }
}
```

测试类

```java
Target adapterTarget = new Adapter();
adapterTarget.request();
```

[源码](..\SourceCode\defign_pattern\src\main\java\com\geely\design\pattern\structural\classadapter)      

## 对象适配器模式

将继承类、调用方法的方式改为new对象、调用方法的方式

```java
public class Adapter implements Target {
    private  Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.adapteeRequest();
    }
}
```

[源码](..\SourceCode\defign_pattern\src\main\java\com\geely\design\pattern\structural\objectadapter)      

### 源码解析

XmlAdapter

Spring的AdvisorAdapter，MethodBeforeAdviceAdapter

Spring的jpa --- JpaVendorAdapter -- AbstractJpaVendorAdapter

SpringMVC的HandlerAdapter,DispatcherServlet类调用

SimpleControllerHandlerAdapter

