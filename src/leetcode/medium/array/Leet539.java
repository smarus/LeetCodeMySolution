package leetcode.medium.array;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Given a list of 24-hour clock time points in "HH:MM"
// format, return the minimum minutes
// difference between any two time-points in the list.

//Input: timePoints = ["23:59","00:00"]
//Output: 1

//Input: timePoints = ["00:00","23:59","00:00"]
//Output: 0
public class Leet539 {
    private static Comparator<String> order = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            String sub1 = o1.substring(0, o1.indexOf(':'));
            String sub1_ = o1.substring(o1.indexOf(":"), o1.length() - 1);
            String sub2 = o2.substring(0, o2.indexOf(':'));
            String sub2_ = o2.substring(o2.indexOf(":"), o2.length() - 1);
            return 0;
        }
    };

    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        System.out.println();
        return 3;
    }


}
