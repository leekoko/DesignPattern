# 工厂方法模式   

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
