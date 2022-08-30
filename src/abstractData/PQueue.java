package abstractData;


import java.util.Map;
import java.util.PriorityQueue;

public class PQueue {
    int[] array;
    int N = 0;

    public PQueue(int capacity) {
        array = new int[capacity + 1];
    }

    public int getMax() {
        return array[1];
    }

    private void swim(int k) {
        int index = (k - 1) / 2;
        while (k > 1 && array[index] < array[k]) {
            swap(k, index);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && array[j] < array[j + 1]) j++;
            if (!(array[k] < array[j])) break;
            swap(k, j);
            k = j;
        }
    }

    public void insert(int i) {
        array[++N] = i;
        swim(N);
    }

    public int deleteMax() {
        int max = array[1];
        swap(1, N--);
        sink(1);
        array[N + 1] = 0;
        return max;
    }


    public void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
