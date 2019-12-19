# 备忘录模式    

特点：相当于存档，通过栈存储对象，需要时回退；使用得比较少。

由  原发器 + 备忘录 + 负责人 组成：

- 原发器：创建备份、恢复备份
- 备忘录：存储原发器的状态
- 负责人：负责设置、获取备忘录，不对具体内容做操作

负责人和原发器的对接，由客户端程序负责。

缺点：对资源消耗大

核心代码：

原发器：

```java
public class Role {
    private int bloodFlow;
    private int magicPoint;

...

    /**
     * @desc 展示角色当前状态
     * @return void
     */
    public void display(){
        System.out.println("用户当前状态:");
        System.out.println("血量:" + getBloodFlow() + ";蓝量:" + getMagicPoint());
    }

    /**
     * @desc 保持存档、当前状态
     * @return
     * @return Memento
     */
    public Memento saveMemento(){
        return new Memento(getBloodFlow(), getMagicPoint());
    }

    /**
     * @desc 恢复存档
     * @param memento
     * @return void
     */
    public void restoreMemento(Memento memento){
        this.bloodFlow = memento.getBloodFlow();
        this.magicPoint = memento.getMagicPoint();
    }
}
```

负责人：

```java
public class Caretaker {
    Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
```

备忘录：

```java
public class Memento {
    private int bloodFlow;
    private int magicPoint;
	...
}
```

客户端：

```java
    public static void main(String[] args) {
        //打BOSS之前：血、蓝全部满值
        Role role = new Role(100, 100);
        System.out.println("----------大战BOSS之前----------");
        role.display();

        //保持进度
        Caretaker caretaker = new Caretaker();
        caretaker.memento = role.saveMemento();

        //大战BOSS，快come Over了
        role.setBloodFlow(20);
        role.setMagicPoint(20);
        System.out.println("----------大战BOSS----------");
        role.display();

        //恢复存档
        role.restoreMemento(caretaker.getMemento());
        System.out.println("----------恢复----------");
        role.display();

    }
```

[源码](..\SourceCode\defign_pattern\src\main\java\com\geely\design\pattern\behavioral\memento)    

### 源码解析

Spring-webflow的StateMessageableMessageContext
