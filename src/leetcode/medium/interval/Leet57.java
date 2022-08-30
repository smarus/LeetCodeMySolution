package leetcode.medium.interval;

import java.util.ArrayList;
import java.util.List;

public class Leet57 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {6, 9}};
        int[] newInterval = new int[]{2, 5};


        for (int[] array : insert(intervals, newInterval)) {
            System.out.println("[" + array[0] + ", " + array[1] + "]");
        }

        intervals = new int[][]{{1, 3}, {6, 9}};
        newInterval = new int[]{2, 5};
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0)
            return new int[][]{newInterval};

        List<int[]> newIntervals = new ArrayList<>();

        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            newIntervals.add(intervals[i]);
            i++;
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        newIntervals.add(newInterval);

        while (i < intervals.length) {
            newIntervals.add(intervals[i]);
            i++;
        }

        return newIntervals.toArray(new int[newIntervals.size()][]);
    }

}
