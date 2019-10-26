package com.geely.design.pattern.structural.proxy;

public class OrderServiceImpl implements IOrderService{
    private IOrderDao iOrderDao;

    @Override
    public int saveOrder(Order order) {
        //Spring会自己注入IOrderDao
        iOrderDao = new OrderDaoImpl();

        System.out.println("Service层调用Dao层添加Order");
        return iOrderDao.insert(order);
    }
}
