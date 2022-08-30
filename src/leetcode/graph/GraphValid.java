package leetcode.graph;

public class GraphValid {
    public static void main(String[] args) {

        int[] array = new int[]{3, 0, 3};
        //  int [] array = new int[] {1,2, -3,3};
        int target = 3;

        int l = 0;

        int count = 0;
        int sum = 0;
        for (int r = 0; r < array.length; r++) {
            sum += array[r];

            while (sum > target) {
                sum -= array[l];
                l++;
            }
            if (sum == target)
                count++;
        }

        System.out.println(count);
    }
}
