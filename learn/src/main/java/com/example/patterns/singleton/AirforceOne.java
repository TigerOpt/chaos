package com.example.patterns.singleton;

public class AirforceOne {
    /**
     * 在多线程的时候，这种方式可能会创建多个对象。
     * eg：假设线程A获取该对象，在判断为null为真，创建之前，上下文进行了切换，
     * 此时，线程B也获取该对象，发现实例为空，进行了创建，这之后，线程A切回来后，会继续创建对象.
     * 那怎么样才能解决上面所说的问题呢？
     * 1、给getInstance()方法添加synchronized，如下所示  —— 这种方式有个问题，同步开销很大
     * synchronized public static AirforceOne getInstance()
     * 2、对实例进行静态初始化，如下所示 —— 这种方式，即时未使用时也会初始化，如果该对象创建开销较大，可能会降低性能
     * private static AirforceOne onlyInstance = new AirforceOne();
     * 3、双重检查锁定，见AirforceOneWithDoubleCheckedLocking.java
     */
    private static AirforceOne onlyInstance;

    private AirforceOne() {
    }

    public void fly() {
        System.out.println("Airforce one is flying...");
    }

    // Create a static method for object creation
    public static AirforceOne getInstance() {

        // Only instantiate the object when needed.
        if (onlyInstance == null) {
            onlyInstance = new AirforceOne();
        }

        return onlyInstance;
    }
}
