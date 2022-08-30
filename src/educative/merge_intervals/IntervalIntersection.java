package educative.merge_intervals;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {

    public static void main(String[] args) {
        Interval[] input1 = new Interval[]{new Interval(1, 3), new Interval(5, 6), new Interval(7, 9)};
        Interval[] input2 = new Interval[]{new Interval(2, 3), new Interval(5, 7)};
        Interval[] result = IntervalIntersection.merge(input1, input2);
        System.out.println("Interval Intersection: ");
        for (Interval interval : result) {
            System.out.print("[" + interval.start + "," + interval.end + "]");
        }
        System.out.println();
        input1 = new Interval[]{new Interval(1, 3), new Interval(5, 7), new Interval(9, 12)};
        input2 = new Interval[]{new Interval(5, 10)};
        result = IntervalIntersection.merge(input1, input2);
        System.out.println("Interval Intersection: ");
        for (Interval interval : result) {
            System.out.print("[" + interval.start + "," + interval.end + "]");
        }
    }


    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalIntersection = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {

            if ((arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end) ||
                    (arr2[j].start > arr1[i].start && arr2[j].start <= arr1[i].end)) {
                intervalIntersection.add(new Interval(
                                Math.max(arr1[i].start, arr2[j].start),
                                Math.min(arr1[i].end, arr2[j].end)
                        )
                );
            }
            if (arr1[i].end < arr2[j].end) {
                i++;
            } else {
                j++;
            }
        }

        return intervalIntersection.toArray(new Interval[intervalIntersection.size()]);
    }

}

