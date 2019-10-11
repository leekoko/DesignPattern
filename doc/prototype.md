# 原型模式

原型模式可以通过拷贝原型创建新的对象，以此来解决创建多个类消耗资源、创建对象过程繁琐的问题。

特点：通过实现CloneAble接口的clone方法，对原型进行克隆

缺点：克隆复杂对象容易引入风险

## 浅克隆

浅克隆直接对整个对象进行克隆

```java
public class Mail implements Cloneable{
    private String name;
    private String emailAddress;
    private String content;
...
    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("clone mail obj");
        return super.clone();
    }

}
```

## 深克隆

深克隆除了对对象进行克隆，还需要对属性进行克隆

```java
public class Pig implements Cloneable{
    private String name;
    private Date birthday;
...
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //浅克隆   属性用的是同一个
        Pig pig = (Pig) super.clone();
        //深克隆
        pig.birthday = (Date) pig.birthday.clone();
        return pig;
    }
}
```

[源码](..\SourceCode\defign_pattern\src\main\java\com\geely\design\pattern\creational\prototype)  

### 源码解析

Object的clone()方法

ArrayList的clone()方法

HashMap的clone()方法

CacheKey的clone()方法