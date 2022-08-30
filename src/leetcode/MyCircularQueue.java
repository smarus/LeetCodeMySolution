package leetcode;


import java.util.ArrayList;
import java.util.List;
//
//MyCircularQueue(k) Initializes the object with the size of the queue to be k.
//        int Front() Gets the front item from the queue. If the queue is empty, return -1.
//        int Rear() Gets the last item from the queue. If the queue is empty, return -1.
//        boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
//        boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
//        boolean isEmpty() Checks whether the circular queue is empty or not.
//        boolean isFull() Checks whether the circular queue is full or not.


//Input
//        ["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
//        [[3], [1], [2], [3], [4], [], [], [], [4], []]
//        Output
//        [null, true, true, true, false, 3, true, true, true, 4]
//
//        Explanation
//        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
//        myCircularQueue.enQueue(1); // return True
//        myCircularQueue.enQueue(2); // return True
//        myCircularQueue.enQueue(3); // return True
//        myCircularQueue.enQueue(4); // return False
//        myCircularQueue.Rear();     // return 3
//        myCircularQueue.isFull();   // return True
//        myCircularQueue.deQueue();  // return True
//        myCircularQueue.enQueue(4); // return True
//        myCircularQueue.Rear();     // return 4
class MyCircularQueue {
    int[] data;
    int pointerStart = 0;
    int pointerEnd = 0;
    int n;

    public MyCircularQueue(int k) {
        data = new int[k];
        n = k;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1)); // return True
        System.out.println(myCircularQueue.enQueue(2)); // return True
        System.out.println(myCircularQueue.enQueue(3)); // return True
        System.out.println(myCircularQueue.enQueue(4)); // return False
        System.out.println(myCircularQueue.Rear());     // return 3
        System.out.println(myCircularQueue.isFull());   // return True
        System.out.println(myCircularQueue.deQueue());  // return True
        System.out.println(myCircularQueue.enQueue(4)); // return True
        System.out.println(myCircularQueue.Rear());     // return 4
    }

    public boolean enQueue(int value) {
        if (pointerEnd >= n)
            return false;

        data[pointerEnd++] = value;
        return true;
    }

    public boolean deQueue() {
        if (pointerStart >= data.length)
            return false;
        pointerStart++;
        return true;
    }

    public int Front() {
        if (pointerStart == 0 && pointerEnd == 0)
            return -1;

        return data[pointerStart];

    }

    public int Rear() {
        if (pointerStart == 0 && pointerEnd == 0) return -1;
        return data[pointerEnd - 1];
    }

    public boolean isEmpty() {
        return pointerStart == 0 || pointerEnd == 0;
    }

    public boolean isFull() {
        return pointerEnd == data.length;
    }
}