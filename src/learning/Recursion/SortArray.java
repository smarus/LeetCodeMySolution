package learning.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArray {


    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(5, 1, 0, 2));
        sortArray(array);
        System.out.println(array);
    }


    public static void sortArray(List<Integer> arr) {
        if (arr.size() == 1)
            return;

        int temp = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        sortArray(arr);
        insert(arr, temp);

    }

    public static void insert(List<Integer> arr, Integer temp) {

        if (arr.isEmpty() || temp >= arr.get(arr.size() - 1)) {
            arr.add(temp);
            return;
        }
        int val = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        insert(arr, temp);
        arr.add(val);

    }
}

