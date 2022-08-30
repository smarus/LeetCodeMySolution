package educative.merge_intervals;

import edu.princeton.cs.algs4.In;

import java.util.*;

public class InsertInterval {

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(5, 7));
        list.add(new Interval(8, 12));

        Interval insertedInterval = new Interval(4, 6);


        for (Interval interval : insertInterval(list, insertedInterval)) {
            System.out.println("[" + interval.start + ", " + interval.end + "]");
            //[1,3][4,7],[8 ,12]
        }

    }

    public static List<Interval> insertInterval1(List<Interval> intervals, Interval insertedInterval) {
        if (intervals.size() == 0) {
            intervals.add(insertedInterval);
            return intervals;
        }

        intervals.add(insertedInterval);
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        Iterator<Interval> intervalIterator = intervals.iterator();
        Interval interval = intervalIterator.next();
        int start = interval.start;
        int end = interval.end;
        List<Interval> resultInterval = new LinkedList<>();
        while (intervalIterator.hasNext()) {
            Interval nextInterval = intervalIterator.next();
            if (nextInterval.start <= end) {
                end = Math.max(end, nextInterval.end);
            } else {
                resultInterval.add(new Interval(start, end));
                start = nextInterval.start;
                end = nextInterval.end;
            }
        }

        resultInterval.add(new Interval(start, end));

        return resultInterval;

    }

    public static List<Interval> insertInterval(List<Interval> intervals, Interval insertedInterval) {

        if (intervals == null || intervals.isEmpty()) {
            intervals = new ArrayList<>();
            intervals.add(insertedInterval);
            return intervals;
        }

        List<Interval> mergedInterval = new ArrayList<>();
        int i = 0;

        while (i < intervals.size() && intervals.get(i).end < insertedInterval.start) {
            mergedInterval.add(intervals.get(i++));
        }
        while (i < intervals.size() && intervals.get(i).start <= insertedInterval.end) {
            insertedInterval.start = Math.min(intervals.get(i).start, insertedInterval.start);
            insertedInterval.end = Math.max(intervals.get(i).end, insertedInterval.end);
            i++;
        }

        mergedInterval.add(insertedInterval);

        while (i < intervals.size()) {
            mergedInterval.add(intervals.get(i++));
        }

        return mergedInterval;

    }

//    public static int [][] insertInterval(int[][] intervals, int [] insertedInterval){
//        if (intervals == null || intervals.length == 0){
//            return new int[][]{insertedInterval};
//        }
//
//        List<int[]> mergedInterval = new ArrayList<>();
//
//        int i = 0;
//
//        while (i < intervals.length && intervals[i][0] < insertedInterval[0]){
//            mergedInterval.add(intervals[i++]);
//        }
//
//        while (i < intervals.length &&)
//    }

}
