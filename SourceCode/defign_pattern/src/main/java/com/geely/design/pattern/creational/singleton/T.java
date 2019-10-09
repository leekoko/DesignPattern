package com.geely.design.pattern.creational.singleton;

public class T implements Runnable{

    @Override
    public void run() {
//        LazySingleton lazySingleton = LazySingleton.getInstance();

//        LazyDoubleCheckSingleton lazyDoubleCheckSingleton = LazyDoubleCheckSingleton.getInstance();
//        System.out.println(Thread.currentThread().getName() + "program end");

//        ContainerSingleton.putInstance("object",new Object());
//        ContainerSingleton.getInstance("object");

        ThreadLocalInstance instance = ThreadLocalInstance.getInstance();

    }
}
