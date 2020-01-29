package easy.arrays;

public class Leet283 {
    public static void main(String[] args) {
        int[] array1 = new int[]{0, 1, 0, 3, 12};

        System.out.println();
        moveZeroes(array1);
        // Output: [1,3,12,0,0]
        for (int a : array1) {
            System.out.println(a);
        }
    }

    public static void moveZeroes(int[] nums) {
        int[] array = new int[nums.length];

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                array[j] = nums[i];
                j++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = array[i];
            array[i] = 0;
        }

    }
}
