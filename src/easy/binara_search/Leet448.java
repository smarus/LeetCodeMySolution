package easy.binara_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leet448 {

    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = findDisappearedNumbers(array);
        for (Integer integer : list)
            System.out.println(integer);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int N = nums.length + 1;
        List<Integer> list = new ArrayList<>();
        int[] numsIndex = new int[N];
        for (int i = 0; i < nums.length; i++) {
            numsIndex[nums[i]]++;
        }

        for (int i = 1; i < numsIndex.length; i++) {
            if (numsIndex[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }

    //Best approach
//    public List<Integer> findDisappearedNumbers(int[] nums) {
//        List<Integer> ret = new ArrayList<Integer>();
//
//        for(int i = 0; i < nums.length; i++) {
//            int val = Math.abs(nums[i]) - 1;
//            if(nums[val] > 0) {
//                nums[val] = -nums[val];
//            }
//        }
//
//        for(int i = 0; i < nums.length; i++) {
//            if(nums[i] > 0) {
//                ret.add(i+1);
//            }
//        }
//        return ret;
//    }
}
