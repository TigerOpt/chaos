package com.example.multithreading;

/**
 * 阻塞队列是指，如果队列中没有更多空间来添加新入队项，则阻塞入队方法的调用者的队列。同样，
 * 如果队列中没有项，则阻塞出队调用者。此外，当空间可用时，队列会通知阻塞的入队线程，当队
 * 列中有项可用时，队列会通知阻塞的出队线程。
 */
public class BlockingQueue<T> {
    T[] array;
    int size = 0;
    int capacity;
    int head = 0;
    int tail = 0;

    public BlockingQueue(int capacity) {
        array = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public synchronized void enqueue(T item) throws InterruptedException {
        while (size == capacity) {
            wait();
        }

        if (tail == capacity) {
            tail = 0;
        }

        array[tail] = item;
        size++;
        tail++;


        notifyAll();

    }

    public synchronized T dequeue() throws InterruptedException {
        T item = null;

        while (size == 0) {
            wait();
        }

        if (head == capacity) {
            head = 0;
        }

        item = array[head];
        array[head] = null;
        head++;
        size--;

        notifyAll();

        return item;
    }
}
