# 适配器模式

loading

前提摘要：当业务开发后需求变更，导致接口不适配。为复用现有类的功能，可以用到适配器模式。

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

目标方法实现类

```java
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("ConcreteTarget目标方法");
    }
}
```

适配器类

```java
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.adapteeRequest();
    }
}
```

[源码](..\SourceCode\defign_pattern\src\main\java\com\geely\design\pattern\structural\decorator)      

## 对象适配器模式





### 源码解析

XmlAdapter

Spring的AdvisorAdapter，MethodBeforeAdviceAdapter

Spring的jpa --- JpaVendorAdapter -- AbstractJpaVendorAdapter

SpringMVC的HandlerAdapter,DispatcherServlet类调用

SimpleControllerHandlerAdapter

