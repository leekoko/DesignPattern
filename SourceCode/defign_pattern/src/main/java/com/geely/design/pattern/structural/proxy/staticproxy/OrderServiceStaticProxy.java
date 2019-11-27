package com.geely.design.pattern.structural.proxy.staticproxy;

import com.geely.design.pattern.structural.proxy.IOrderService;
import com.geely.design.pattern.structural.proxy.Order;
import com.geely.design.pattern.structural.proxy.OrderServiceImpl;
import com.geely.design.pattern.structural.proxy.db.DataSourceContextHolder;

public class OrderServiceStaticProxy implements IOrderService{

    //代理实现类
    private IOrderService iOrderService;

    /**
     * 代理方法
     * @param order
     * @return
     */
    @Override
    public int saveOrder(Order order){
        //预处理
        beforeMethod(order);
        iOrderService = new OrderServiceImpl();
        //实际目标方法
        int result = iOrderService.saveOrder(order);
        //后处理
        afterMethod();
        return result;
    }

    /**
     * 预处理
     * @param order
     */
    private void beforeMethod(Order order){
        int userId = order.getUserId();
        int dbRouter = userId % 2;
        System.out.println("静态代理分配到【db" + dbRouter + "】库");
        //todo 设置dataSource
        DataSourceContextHolder.setDBType(String.valueOf(dbRouter));
        System.out.println("静态代理before code");
    }

    /**
     * 后处理
     */
    private void afterMethod(){
        System.out.println("静态代理after code");
    }
}
