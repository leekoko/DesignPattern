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

缺点：容易产生垃圾对象

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

缺点：加了synchronized之后线程安全，但是效率很低

## 双重校验锁

双重校验锁在兼顾懒汉模式的优点情况下，提高了效率。

```java
public class Singleton {  
    private volatile static Singleton singleton;  
    private Singleton (){}  
    public static Singleton getSingleton() {  
    if (singleton == null) {  
        synchronized (Singleton.class) {  
        if (singleton == null) {  
            singleton = new Singleton();  
        }  
        }  
    }  
    return singleton;  
    }  
}
```

## 登记式

修改饿汉模式为懒加载

```java
public class Singleton {  
    private static class SingletonHolder {  
    private static final Singleton INSTANCE = new Singleton();  
    }  
    private Singleton (){}  
    public static final Singleton getInstance() {  
    	return SingletonHolder.INSTANCE;  
    }  
}
```

## 枚举

推荐的写法，支持序列化机制。但比较少人用。

```java
public enum Singleton {  
    INSTANCE;  
    public void whateverMethod() {  
    }  
}
```

