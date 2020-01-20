package medium.array;
//
//Given an array nums containing n + 1
//        integers where each integer is between 1
//        and n (inclusive), prove that at least one
//        duplicate number must exist. Assume that there
//        is only one duplicate number, find the duplicate one.

//You must not modify the array (assume the array is read only).
//        You must use only constant, O(1) extra space.
//        Your runtime complexity should be less than O(n2).
//        There is only one duplicate number in the array, but it could be repeated more than once.

public class Leet287 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 4, 2, 2};
        System.out.println(findDuplicate(array));
    }

    public static int findDuplicate(int[] nums) {
        int[] occurences = new int[nums.length];

        for (int num : nums) {
            occurences[num]++;
        }

        int ocured = 0;
        for (int i = 0; i < occurences.length; i++) {
            if (occurences[i] >= 2) {
                ocured = i;
                break;
            }
        }
        return ocured;
    }
}
