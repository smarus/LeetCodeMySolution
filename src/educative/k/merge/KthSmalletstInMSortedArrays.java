package educative.k.merge;

import java.util.ArrayList;
import java.util.List;

public class KthSmalletstInMSortedArrays {

    public static void main(String[] args) {
        Integer[] l1 = new Integer[]{2, 6, 8};
        Integer[] l2 = new Integer[]{3, 6, 7};
        Integer[] l3 = new Integer[]{1, 3, 4};

        List<Integer[]> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);

        int result = KthSmalletstInMSortedArrays.findKthSmallest(lists, 5);
        System.out.println(result);
    }


    public static int findKthSmallest(List<Integer[]> lists, int k) {


        return -1;
    }
}


