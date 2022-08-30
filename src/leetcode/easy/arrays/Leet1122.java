package leetcode.easy.arrays;

import java.util.*;

public class Leet1122 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        int[] arr = relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(arr));

    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map1.put(arr1[i], map1.getOrDefault(arr1[i], 0) + 1);
        }
        for (int i = 0; i < arr2.length; i++) {
            map2.put(arr2[i], i);
        }
        int[] arr = new int[arr1.length];
        int k = 0;
        for (int i = 0; i < arr2.length; i++) {
            int occurences = map1.get(arr2[i]);
            while (occurences != 0) {
                arr[k] = arr2[i];
                occurences--;
                k++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            if (!map2.containsKey(arr1[i])) {
                list.add(arr1[i]);
            }
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            arr[k] = list.get(i);
            k++;
        }

        return arr;
    }
}
