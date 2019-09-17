# 工厂模式   

什么是简单工厂模式？

## 1.工厂方法模式

M：什么是工厂方法模式呢？

Z：这是一种创建类的模式，当一个类的创建步骤比较复杂，则可以引入工厂类，将复杂的创建类操作交给工厂实现即可，用户无需关心具体是怎么操作的。

M：什么算做复杂的创建步骤呢？

Z：在我理解来复杂的创建步骤常见有两种情况：

1. 实例化过程复杂   

   ```java
       class Engine {
           public void getStyle(){
               System.out.println("这是汽车的发动机");
           }
       }
       class Underpan {
           public void getStyle(){
               System.out.println("这是汽车的底盘");
           }
       }
       class Wheel {
           public void getStyle(){
               System.out.println("这是汽车的轮胎");
           }
       }
       public class Client {
           public static void main(String[] args) {
               Engine engine = new Engine();
               Underpan underpan = new Underpan();
               Wheel wheel = new Wheel();
               ICar car = new Car(underpan, wheel, engine);
               car.show();
           }
       }
   ```

   main方法里面的，要new三个对象作为new Car的参数。而对于使用者，其实只要能使用show方法就可以了。   

   所以将其创建过程包装为工厂类，调用返回对象之后，再调用对象里面的方法。

   ```java
       interface IFactory {
           public ICar createCar();
       }
       class Factory implements IFactory {
           public ICar createCar() {
               Engine engine = new Engine();
               Underpan underpan = new Underpan();
               Wheel wheel = new Wheel();
               ICar car = new Car(underpan, wheel, engine);
               return car;
           }
       }
       public class Client {
           public static void main(String[] args) {
               IFactory factory = new Factory();
               ICar car = factory.createCar();
               car.show();
           }
       }
   ```

2. 新增一个新的类时，修改的代码复杂  

   除了要修改工厂类的代码，使用者的代码也需要修改。而使用了工厂模式之后，使用者不用关心那么多，也同时实现了工厂端代码和使用者代码的解耦。

M：总结一下，提供被实例化的类的时候，尽量利用工厂类做到封装，便于解耦和简单调用。

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