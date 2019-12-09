# 策略模式

前提摘要：当有一些算法相似，但行为不同的逻辑。通过if...else进行区分，有时会嵌套很多层，不利于维护。策略模式可以动态使用不同的行为。

特点：将不同的算法提取出来，封装成多个类，任意进行切换。

缺点：策略类会增多，需要配合其他模式使用。

核心源码：

统一结构抽象类:

```java
public interface PromotionStrategy {
    void doPromotion();
}
```

实现接口的实体类:

```java
public class FanXianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现，返回的金额存放到慕课网余额");
    }
}
```

策略类统一入口：

```java
public class PromotionActivity extends PromotionStrategyFactory {   //继承为工厂模式准备
    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void executePromotionStrategy(){
        promotionStrategy.doPromotion();
    }
}
```

测试类：

```java
        PromotionActivity promotionActivity1111 = new PromotionActivity(new FanXianPromotionStrategy());
        promotionActivity1111.executePromotionStrategy();
```

## 策略模式+简单工厂模式

上方直接new对象的方法需要引入包，创建类。可以进行优化，引入简单工厂模式，传参即创建对象。

工厂类：

```java
public class PromotionStrategyFactory {
    private static Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<String, PromotionStrategy>();
    static {
        PROMOTION_STRATEGY_MAP.put(PromotionKey.LIJIAN, new LijianPromotionStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.FANXIAN, new FanXianPromotionStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.MANJIAN, new ManJianPromotionStrategy());
    }

    private static final PromotionStrategy NO_PROMOTION = new EmptyPromotionStrategy();

    public PromotionStrategyFactory(){

    }

    public static PromotionStrategy getPromotionStrategy(String promotionKey){
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotionKey);
        return promotionStrategy == null ? null : promotionStrategy;
    }

    private interface PromotionKey extends PromotionStrategy {
        String LIJIAN = "LIJIAN";
        String FANXIAN = "FANXIAN";
        String MANJIAN = "MANJIAN";
    }
}
```

测试类：

```java
		String promotionKey = "LIJIAN";
        PromotionActivity promotionActivity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
        promotionActivity.executePromotionStrategy();
```

[源码](..\SourceCode\defign_pattern\src\main\java\com\geely\design\pattern\behavioral\strategy)    

