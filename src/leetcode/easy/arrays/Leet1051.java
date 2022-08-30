package leetcode.easy.arrays;

import java.util.Arrays;

//Students are asked to stand in non-decreasing order of heights for an annual photo.
//
//Return the minimum number of students not standing in the right positions.
// (This is the number of students that must move in order for all
// students to be standing in non-decreasing order of height.)
public class Leet1051 {

    public static void main(String[] args) {
        int a[] = new int[]{1, 1, 4, 2, 1, 3};
        System.out.println(heightChecker(a));
    }

    public static int heightChecker(int[] heights) {
        int[] b = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            b[i] = heights[i];
        }
        Arrays.sort(heights);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != b[i])
                count++;
        }

        return count;
    }
}


