package easy.binara_search;

import java.util.HashMap;
import java.util.Map;

public class Leet217 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 1};
        int[] array2 = new int[]{1, 2, 3, 4};
        int[] array3 = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(array));
        System.out.println(containsDuplicate(array2));
        System.out.println(containsDuplicate(array3));


    }

    public static boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1)
            return false;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int val = map.get(nums[i]) + 1;
                map.put(nums[i], val);
            } else {
                map.put(nums[i], 0);
            }
        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() >= 1)
                return true;
        }
        return false;
    }
}
