package com.zeyu.LinkedList;

/**
 * @Auther: Zeyu Ni
 * @Date: 4/3/21 - 04 - 03 - 10:39 AM
 * @Description: com.msb
 * @Version: 1.0
 */
class ListNode {
    ListNode next;
    int val;

    public ListNode(int val) {
        this.val = val;
        next = null;
    }
}

public class MyLinkedList {
    ListNode dummyHead;
    ListNode tail;
    int length;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        dummyHead = new ListNode(0);
        tail = null;
        length = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (dummyHead.next == null || index < 0 || length < index + 1) {
            return -1;
        }
        ListNode cur = dummyHead.next;
        while (cur.next != null && index > 0) {
            cur = cur.next;
            index--;
        }

        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        length++;

        newHead.next = dummyHead.next;
        dummyHead.next = newHead;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode newTail = new ListNode(val);
        length++;
        if (tail == null) {
            dummyHead.next = newTail;
            tail = newTail;
            return;
        }

        tail.next = newTail;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode newNode = new ListNode(val);
        if (length < index) {
            return;
        }
        length++;
        ListNode cur = dummyHead;
        while (cur.next != null && index > 0) {
            cur = cur.next;
            index--;
        }

        newNode.next = cur.next;
        cur.next = newNode;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (length < index + 1) {
            return;
        }
        length--;
        ListNode cur = dummyHead;
        while (cur.next != null && index > 0) {
            cur = cur.next;
            index--;
        }

        cur.next = cur.next.next;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
        linkedList.get(1);            // returns 2
        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
        linkedList.get(1);            // returns 3
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

