package easy.arrays;

public class Leet1365 {
    public static void main(String[] args) {
        int[] nums = new int[]{8, 1, 2, 2, 3};
        int[] num = smallerNumbersThanCurrent(nums);
        for (int i : num) {
            System.out.println(i);
        }

    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] num = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i == j)
                    continue;

                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            num[index] = count;
            index++;
        }
        return num;
    }
}
