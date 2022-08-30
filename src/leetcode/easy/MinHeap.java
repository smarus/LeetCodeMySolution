package leetcode.easy;

import java.util.Arrays;

public class MinHeap {
    int[] heap;
    int n = 0;


    public MinHeap(int size) {
        heap = new int[size + 1];
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.offer(10);
        minHeap.heapString();
        minHeap.offer(9);
        minHeap.heapString();
        minHeap.offer(8);
        minHeap.heapString();
        minHeap.offer(7);
        minHeap.heapString();
        minHeap.offer(6);
        minHeap.heapString();
        minHeap.offer(7);
        minHeap.heapString();
        minHeap.offer(11);
        System.out.println(minHeap.peek());
        System.out.println(minHeap.pop());
        System.out.println(minHeap.pop());
        minHeap.heapString();
    }

    public void offer(int k) {
        n++;
        heap[n] = k;
        swim(n);
    }

    public int pop() {
        int max = heap[1];
        swap(1, n--);
        heap[n + 1] = 0;
        sink(1);
        return max;
    }

    public int peek() {
        return heap[1];
    }

    public void swim(int k) {
        while (k > 0 && isLess(k, k / 2)) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    public void sink(int k) {
        while (k * 2 < n) {
            int j = 2 * k;
            System.out.println(j + " :" + (j + 1));
            if (j < n && isGreater(j, j + 1)) j++;
            if (isLess(k, j)) break;
            ;
            swap(j, k);
            k = j;
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public boolean isGreater(int i, int j) {
        return heap[i] > heap[j];
    }

    public boolean isLess(int i, int j) {
        return heap[i] < heap[j];
    }

    public void heapString() {
        System.out.println(Arrays.toString(heap));
    }
}
