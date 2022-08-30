package educative.top_k_largest;

import java.util.PriorityQueue;

public class ConnectRopes {

    public static void main(String[] args) {

        int[] rope = new int[]{1, 3, 11, 5};

        System.out.println(minimumCostToConnection(rope));
    }

    public static int minimumCostToConnection(int[] ropeLengths) {
        if (ropeLengths.length == 0)
            return 0;


        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < ropeLengths.length; i++) {
            minHeap.offer(ropeLengths[i]);
        }

        int sum = minHeap.poll();

        for (int i = 0; i < minHeap.size(); i++) {
            sum += minHeap.poll();
        }

        return sum;
    }
}
