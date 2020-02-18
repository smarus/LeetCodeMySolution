package easy.two_pointer;

import java.util.*;

public class Leet350 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 2, 1};
        int[] array2 = new int[]{2, 2};
        int[] array3 = new int[]{4, 9, 5};
        int[] array4 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect(array, array2)));
        System.out.println(Arrays.toString(intersect(array3, array4)));


    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            int freq = map.getOrDefault(i, 0);
            map.put(i, freq + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (map.get(i) != null && map.get(i) > 0) {
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
//Two pointer solution it good but my way more better I think
//    public int[] intersect(int[] nums1, int[] nums2) {
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        int n = nums1.length, m = nums2.length;
//        int i = 0, j = 0;
//        List<Integer> list = new ArrayList<>();
//        while(i < n && j < m){
//            int a = nums1[i], b= nums2[j];
//            if(a == b){
//                list.add(a);
//                i++;
//                j++;
//            }else if(a < b){
//                i++;
//            }else{
//                j++;
//            }
//        }
//        int[] ret = new int[list.size()];
//        for(int k = 0; k < list.size();k++) ret[k] = list.get(k);
//        return ret;
//    }
