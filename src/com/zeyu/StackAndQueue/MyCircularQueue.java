package com.zeyu.StackAndQueue;

/**
 * @Auther: Zeyu Ni
 * @Date: 4/5/21 - 04 - 05 - 5:06 PM
 * @Description: com.laioffer
 * @Version: 1.0
 */

class MyCircularQueue {
    int[] array;
    int head;
    int tail;
    int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        array = new int[k];
        head = 0;
        tail = 0;
        size = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (size == array.length) {
            return false;
        }

        array[tail] = value;
        size++;
        tail =  tail + 1 == array.length ? 0 : tail + 1;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (size == 0) {
            return false;
        }

        head = head + 1 == array.length ? 0 : head + 1;
        size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (size == 0) {
            return -1;
        }

        int front = 0;
        if (head != array.length - 1) {
            front = head + 1;
        }

        return array[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (size == 0) {
            return -1;
        }

        int rear = 0;
        if (tail == 0) {
            rear = array.length - 1;
        } else {
            rear = tail - 1;
        }

        return array[rear];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == array.length;
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(5); // set the size to be 3
        boolean isEmpty = circularQueue.isEmpty();
        circularQueue.enQueue(1);  // return true
        circularQueue.enQueue(2);  // return true
        circularQueue.enQueue(3);  // return true
        circularQueue.enQueue(4);  // return false, the queue is full
        int rear = circularQueue.Rear();  // return 4
        int front = circularQueue.Front();
        boolean isFull = circularQueue.isFull();  // return true
        circularQueue.deQueue();  // return true
        boolean isFull2 = circularQueue.isFull(); // return false
        circularQueue.enQueue(5);  // return true
        int rear2 = circularQueue.Rear();  // return 4
        int front2 = circularQueue.Front();
    }
}
