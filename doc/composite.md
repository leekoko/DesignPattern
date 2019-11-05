# 组合模式

前提摘要：当一个对象是树状结构的时候，可以引入组合模式。

特点：编写叶子构件和容器构件，继承于抽象构件，以保持结构一致。将叶子构件放入容器构件当中，组合成复杂的组合对象。

缺点：层次关系使得设计复杂。

核心代码如下：

抽象构件

```java
public abstract class CatalogComponent {
    public void add(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持增加操作");
    }

    public void remove(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持删除操作");
    }

    public String getName(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持获取名称操作");
    }

    public double getPrice(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持获取价格操作");
    }

    public void print(){
        throw new UnsupportedOperationException("不支持打印操作");
    }

}
```

容器构件：

```java
public class CourseCatalog extends CatalogComponent{
    private List<CatalogComponent> items = new ArrayList<CatalogComponent>();
    private String name;
    private Integer level;

    public CourseCatalog(String name, Integer level) {
        this.name = name;
        this.level = level;
    }
...
}
```

叶子构件：

```java
public class Course extends CatalogComponent {
    private String name;
    private double price;

    public Course(String name, double price) {
        this.name = name;
        this.price = price;
    }
...
}
```

测试类：

```java
public class Test {
    public static void main(String[] args) {
        CatalogComponent linuxCourse = new Course("linux课程",11);
        CatalogComponent windowsCourse = new Course("Windows课程",21);

        CatalogComponent javaCourseCatalog = new CourseCatalog("Java课程目录",2);
        CatalogComponent mmailCourse1 = new Course("Java电商一期", 55);
        CatalogComponent mmailCourse2 = new Course("Java电商二期", 66);
        CatalogComponent designPattern = new Course("Java设计模式", 77);
        javaCourseCatalog.add(mmailCourse1);
        javaCourseCatalog.add(mmailCourse2);
        javaCourseCatalog.add(designPattern);

        CatalogComponent imoocMainCourseCatalog = new CourseCatalog("慕课网课程主目录",1);
        imoocMainCourseCatalog.add(linuxCourse);
        imoocMainCourseCatalog.add(windowsCourse);
        imoocMainCourseCatalog.add(javaCourseCatalog);

        imoocMainCourseCatalog.print();
    }
}
```

[源码](..\SourceCode\defign_pattern\src\main\java\com\geely\design\pattern\structural\composite)    

### 源码解析

Container -- add()  

Hashmap -- putAll()

arrayList -- addAll()

MixedSqlNode

sqlNode