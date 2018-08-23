# 抽象工厂模式

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