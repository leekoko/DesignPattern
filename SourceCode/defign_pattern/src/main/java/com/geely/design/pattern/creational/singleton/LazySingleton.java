package com.geely.design.pattern.creational.singleton;

public class LazySingleton {
    private static LazySingleton lazySingleton = null;
    private static boolean flag = true;

    private LazySingleton(){
        if(flag){
            flag = false;
        }else{
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

    public synchronized static LazySingleton getInstance(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

}
