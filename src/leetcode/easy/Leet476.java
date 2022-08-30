package leetcode.easy;

import java.util.List;
import java.util.PriorityQueue;

public class Leet476 {

    public static void main(String[] args) {

        System.out.println(findComplement(5));
        System.out.println(findComplement(1));
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((a,b)->((a.get(0)+ a.get(1)) - (b.get(0)+ b.get(1))));
    }

    public static int findComplement(int num) {
        int ones = (Integer.highestOneBit(num) << 1) - 1;
        return num ^ ones;
    }
}
