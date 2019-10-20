# 外观模式

前提摘要：当客户程序与多个子系统存在依赖性，调用过程将变得很复杂。于是需要引入外观模式。

特点：外观模式由外观类同一管理子系统之间的联系，然后提供一个简单的接口。外观模式也称门面模式，属于结构型模式。

缺点：违背了开闭原则，增加子系统需要修改外观类和客户端源码

核心代码如下：

外观类，统一管理子系统入口

```java
public class GiftExchangeService {
    //实际使用通过Spring注入
    private QualifyService qualifyService = new QualifyService();
    private PointsPaymentService pointsPaymentService = new PointsPaymentService();
    private ShippingService shippingService = new ShippingService();

    public void giftExchange(PointsGift pointsGift){
        if(qualifyService.isAvailable(pointsGift)){
            //资格校验通过
            if (pointsPaymentService.pay(pointsGift)){
                //支付积分成功
                String shippingOrderNo = shippingService.shipGift(pointsGift);
                System.out.println("物流系统下单成功，订单号是"+shippingOrderNo);
            }
        }
    }
}
```

测试类，调用外观类接口

```java
    public static void main(String[] args) {
        PointsGift pointsGift = new PointsGift("T恤");
        GiftExchangeService giftExchangeService = new GiftExchangeService();
        giftExchangeService.giftExchange(pointsGift);
    }
```

[源码](..\SourceCode\defign_pattern\src\main\java\com\geely\design\pattern\structural\facade)     

### 源码解析

JdbcUtil  

Configuration的new类方法

tomcat的RequestFacade类

tomcat的Request

tomcat的StandardSessionFacade

tomcat的StatementFacade  提高jdbc连接池

