# 装饰模式   

前提摘要：当我们想要给某个类添加扩展行为，可以通过继承。但是继承是静态的，用户没法灵活控制增加行为的方式、时机、组合方式，所以用到了装饰模式。

特点：将一个类的对象嵌入另一个对象中，由另一个对象扩展自己的行为。

缺点：产生很多小对象，增加系统复杂度。

核心代码：

抽象构件角色

```java
public abstract class ABattercake {
    protected abstract String getDesc();
    protected abstract int cost();
}
```

具体构件角色

```java
public class Battercake extends ABattercake {
    @Override
    protected String getDesc() {
        return "煎饼";
    }

    @Override
    protected int cost() {
        return 8;
    }
}
```

装饰角色

```java
public abstract class AbstractDecorator extends ABattercake {
    private ABattercake aBattercake;

    public AbstractDecorator(ABattercake aBattercake){
        this.aBattercake = aBattercake;
    }

    protected abstract void doSomeThing();

    @Override
    protected String getDesc() {
        return this.aBattercake.getDesc();
    }

    @Override
    protected int cost() {
        return this.aBattercake.cost();
    }
}
```

具体装饰角色

```java
public class EggDecorator extends AbstractDecorator{
    public EggDecorator(ABattercake aBattercake) {
        super(aBattercake);
    }

    @Override
    protected void doSomeThing() {

    }

    @Override
    protected String getDesc() {
        return super.getDesc() + " 加一个鸡蛋";
    }

    @Override
    protected int cost() {
        return super.cost() + 1;
    }
}
```

测试类

```java
    public static void main(String[] args) {
        ABattercake aBattercake;
        aBattercake = new Battercake();
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new SausageDecorator(aBattercake);

        System.out.println(aBattercake.getDesc() + " 销售价格：" + aBattercake.cost());
    }
```

[源码](..\SourceCode\defign_pattern\src\main\java\com\geely\design\pattern\structural\decorator)      

### 源码解析

BufferedReader

BufferedInputStream

FileInputStream  

Spring--TransactionAwareCacheDecorator

Servlet--SessionRepositoryRequestWrapper

mybatis--Cache

