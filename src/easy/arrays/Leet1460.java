package easy.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leet1460 {

    //(n log(n)) for sorting
    //O(1)
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);

        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i])
                return false;
        }
        Map<Integer, Integer> map = new HashMap<>();


        return true;
    }

    //O(n) Space(1)
//    public boolean canBeEqual(int[] target, int[] arr) {
//        int sum = 0, v = 0;
//        for (int i = 0; i < target.length; i++) {
//            v ^= target[i];
//            v ^= arr[i];
//            sum += target[i];
//            sum -= arr[i];
//        }
//
//        return sum == 0 && v == 0;
//    }
}
