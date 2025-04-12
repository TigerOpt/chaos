## 介绍

### why?

先看如下代码，

```java
package com.example.multithreading;

public class SumUpExample {
    long startRange;
    long endRange;
    long counter = 0;
    static long MAX_NUM = Integer.MAX_VALUE;

    public SumUpExample(long startRange, long endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }

    public void add() {
        for (long i = startRange; i <= endRange; i++) {
            counter += 1;
        }
    }
  
    static public void twoThreads() throws InterruptedException {
        long start = System.currentTimeMillis();
        SumUpExample s1 = new SumUpExample(1, MAX_NUM / 2);
        SumUpExample s2 = new SumUpExample(1 + (MAX_NUM / 2), MAX_NUM);

        Thread t1 = new Thread(() -> {
            s1.add();
        });

        Thread t2 = new Thread(() -> {
            s2.add();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long finalCount = s1.counter + s2.counter;
        long end = System.currentTimeMillis();
        System.out.println("Two threads final count = " + finalCount + " took " + (end - start));
    }

    static public void oneThread() {
        long start = System.currentTimeMillis();
        SumUpExample s = new SumUpExample(1, MAX_NUM );
        s.add();
        long end = System.currentTimeMillis();
        System.out.println("Single thread final count = " + s.counter + " took " + (end - start));
    }

    public static void runTest() throws InterruptedException {

        oneThread();
        twoThreads();

    }
}

public class Demonstration {
    public static void main(String[] args) throws InterruptedException {
        SumUpExample.runTest();
    }
}
```

执行结果如下所示：

Single thread final count = 2305843008139952128 took 1389
Two threads final count = 2305843008139952128 took 697

由上可见，双线程耗时更短，这就是多线程为什么存在。

总结线程的好处：

1. 更高的吞吐量
2. 给应用程序一种多任务处理的错觉
3. 高效利用资源

线程有以上的优势，那线程有什么劣势呢？

1. 通常很难发现错误
2. 代码维护成本较高
3. 提高系统资源的利用率。每个线程的创建都会消耗额外的内存、CPU 周期（用于记录）以及上下文切换的时间。
4. 由于线程间协调需要付出代价，程序可能会运行缓慢。获取和释放锁会增加程序的执行时间。线程之间争夺锁会导致锁争用。

## 基础知识

### 程序、进程和线程
