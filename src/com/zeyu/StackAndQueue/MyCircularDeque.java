package com.zeyu.StackAndQueue;

/**
 * @Auther: Zeyu Ni
 * @Date: 4/6/21 - 04 - 06 - 7:17 AM
 * @Description: com.laioffer
 * @Version: 1.0
 */
public class MyCircularDeque {
    int[] array;
    int head;
    int tail;
    int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        array = new int[k];
        head = 0;
        tail = 0;
        size = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == array.length) {
            return false;
        }

        head = head - 1 == -1 ? array.length - 1 : head - 1;
        array[head] = value;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == array.length) {
            return false;
        }

        array[tail] = value;
        size++;
        tail =  tail + 1 == array.length ? 0 : tail + 1;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }

        head = head + 1 == array.length ? 0 : head + 1;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }

        tail = tail - 1 == -1 ? array.length - 1 : tail - 1;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (size == 0) {
            return -1;
        }

        return array[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (size == 0) {
            return -1;
        }

        int rear = tail == 0 ? array.length - 1 : tail - 1;

        return array[rear];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == array.length;
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // set the size to be 3
//        boolean b1 = circularDeque.insertLast(1);            // return true
//        boolean b2 = circularDeque.insertLast(2);            // return true
//        boolean b3 = circularDeque.insertFront(3);            // return true
//        boolean b4 = circularDeque.insertFront(4);            // return false, the queue is full
//        int rear = circularDeque.getRear();              // return 2
//        boolean isFull = circularDeque.isFull();                // return true
//        boolean b5 = circularDeque.deleteLast();            // return true
//        boolean b6 = circularDeque.insertFront(4);            // return true
//        int fornt = circularDeque.getFront();
        circularDeque.insertLast(1);
        circularDeque.insertLast(2);
        circularDeque.insertLast(3);
        circularDeque.deleteFront();
        circularDeque.deleteFront();
        circularDeque.deleteFront();
        circularDeque.insertLast(4);
        circularDeque.isEmpty();
        int front = circularDeque.getFront();
    }
}
