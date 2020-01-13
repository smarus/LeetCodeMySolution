package easy.arrays;


public class Leet553 {

    public static void main(String[] args) {

    }

    public String optimalDivision(int[] nums) {
        if (nums.length == 0 || nums == null)
            return "";
        if (nums.length == 1) return nums.toString();

        if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < nums.length; i++) {
            if (i != 1)
                sb.append('/');
            sb.append(nums[i]);

        }
        return nums[0] + "/(" + sb.toString() + ")";
    }
}
