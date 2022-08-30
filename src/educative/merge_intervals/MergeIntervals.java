package educative.merge_intervals;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {

        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 4));
        list.add(new Interval(2, 5));
        list.add(new Interval(7, 9));

        for (Interval interval : mergeInterval(list)) {
            System.out.println("[" + interval.start + ", " + interval.end + "]");
        }
        System.out.println();

        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        for (int[] array : merge(intervals)) {
            System.out.println("[" + array[0] + ", " + array[1] + "]");
        }
    }

    public static List<Interval> mergeInterval(List<Interval> intervals) {
        if (intervals.size() < 2)
            return intervals;

        // sort interval by start time
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        List<Interval> mergedInterval = new LinkedList<>();
        Iterator<Interval> intervalIterator = intervals.iterator();
        Interval interval = intervalIterator.next();
        int start = interval.start;
        int end = interval.end;

        while (intervalIterator.hasNext()) {
            interval = intervalIterator.next();
            if (interval.start <= end) {
                end = Math.max(interval.end, end);
            } else {
                mergedInterval.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }

        }
        mergedInterval.add(new Interval(start, end));

        return mergedInterval;
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length < 2)
            return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else {
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);


    }

}
