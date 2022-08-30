package leetcode.medium.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStone {

    public static void main(String[] args) {
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(stones));
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        };
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int num : stones) {
            pq.offer(num);
        }

        int last = 0;
        while (!pq.isEmpty()) {
            int firstStone = pq.poll();
            last = firstStone;
            if (pq.isEmpty())
                break;

            int secondStone = pq.poll();
            last = Math.abs(firstStone - secondStone);
            if (last != 0)
                pq.offer(last);
        }


        return last;
    }
}
