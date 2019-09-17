# 单例模式

单例模式时，内存只有一个对象，节省资源。

## 饿汉式单例

```java
    public class Singleton {
        private static Singleton singleton = new Singleton();
        private Singleton(){}
        public static Singleton getInstance(){
            return singleton;
        }
    }
```

类在加载的时候就实例化对象。

## 懒汉式单例

```java
    public class Singleton {
        private static Singleton singleton;
        private Singleton(){}

        public static synchronized Singleton getInstance(){
            if(singleton==null){
                singleton = new Singleton();
            }
            return singleton;
        }
    }
```

类在调用时才实例化对象。













