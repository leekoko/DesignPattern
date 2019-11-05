# 桥接模式

前提摘要：扩展类的功能可以使用继承，但是当类的组合较多，继承会导致子类爆炸。通过桥接模式可以灵活扩展类功能，也能保持单一职责原则。

特点：将组合类分为抽象接口和实现部分，根据需求灵活进行组合。

缺点：增加系统复杂度。聚合关系建立在抽象层，需要针对抽象进行设计与编程。

核心代码如下：

抽象接口

```java
public interface Account {
    Account openAccount();
    void showAccountType();

}
```

抽象接口实现

```java
public class DepositAccount implements Account {
    @Override
    public Account openAccount() {
        System.out.println("打开定期账号");
        return new DepositAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是一个定期账号");
    }
}
```

实现部分抽象类

```java
public abstract class Bank {
    protected Account account;
    public Bank(Account account){
        this.account = account;
    }
    abstract Account openAccount();

}
```

实现部分子类

```java
public class ICBCBank extends Bank {

    public ICBCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开工商银行账号");
        account.openAccount();
        return account;
    }
}
```

测试类

```java
...
        Bank icbcBank = new ICBCBank(new DepositAccount());
        Account icbcAccount = icbcBank.openAccount();
        icbcAccount.showAccountType();
...
```

### 源码解析

DriverManager -- registerDriver -- Connection

