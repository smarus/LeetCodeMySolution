package leetcode.easy;


import com.sun.tools.javac.util.Pair;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leet1086 {

    public static void main(String[] args) {
        int[][] item = new int[][]{{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}};


        int[][] result = highFive(item);

        for (int[] it : result) {
            System.out.println(Arrays.toString(it));
        }
    }


    public static int[][] highFive(int[][] items) {
        if (items == null || items.length == 0)
            return items;


        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int[] item : items) {
            priorityQueue.offer(item);
        }

        Map<Integer, Pair<Integer, Integer>> topFive = new HashMap<>();

        while (!priorityQueue.isEmpty()) {
            int[] item = priorityQueue.poll();

            if (!topFive.containsKey(item[0])) {
                topFive.put(item[0], new Pair<>(item[1], 1));
            } else {
                Pair<Integer, Integer> pair = topFive.get(item[0]);
                if (pair.snd < 5) {
                    Pair<Integer, Integer> newPair = new Pair<>(pair.fst + item[1], pair.snd + 1);
                    topFive.put(item[0], newPair);
                }
            }
        }

        int[][] result = new int[topFive.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Pair<Integer, Integer>> pair : topFive.entrySet()) {
            result[index][0] = pair.getKey();
            result[index][1] = (pair.getValue().fst / 5);
            index++;
        }

        return result;
    }


}
