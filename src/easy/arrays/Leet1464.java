package easy.arrays;

public class Leet1464 {

    public int maxProduct(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int value = (nums[i] - 1) * (nums[j] - 1);
                if (value > max)
                    max = value;
            }
        }
        return max;
    }
}
