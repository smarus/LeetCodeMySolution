package algorithms_coursera;

import java.util.Arrays;

public class HelloWorld {

    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        int[] nums = new int[]{1, 1, 2};
        System.out.println(Integer.toBinaryString(22));
        String s = "10110";
        int len = s.indexOf('1', 1);
        System.out.println(len);
        System.out.println("Hello, Worldww");

        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int pointer = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[pointer] != nums[i]) {
                System.out.println(nums[pointer] + "Before");
                pointer++;
                System.out.println(pointer + " pointer");
                nums[pointer] = nums[i];
                System.out.println(nums[pointer] + "after ");

            }
        }
        System.out.println(Arrays.toString(nums));
        return pointer;
    }
}
