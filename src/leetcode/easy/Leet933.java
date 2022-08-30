package leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leet933 {
}

class RecentCounter {
    List<Integer> calls;


    public RecentCounter() {
        calls = new ArrayList<>();

    }

    public int ping(int t) {
        calls.add(t);
        int index = Collections.binarySearch(calls, t - 3000);// searching element in list with (t-3000)
        if (index < 0) {
            index = -index - 1;
        } // element is not in list
        return calls.size() - index;
    }
//fastest this
//    class RecentCounter {
//
//        private LinkedList<Integer> pings;
//        public RecentCounter() {
//            this.pings = new LinkedList<Integer>();
//        }
//
//        public int ping(int t) {
//            int start = t - 3000;
//            while (pings.size() > 0 && pings.getFirst() < start) {
//                pings.remove();
//            }
//            pings.add(t);
//            return pings.size();
//        }
//    }
}
