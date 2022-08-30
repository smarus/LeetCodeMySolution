package educative.dp;

public class MinCostClimbingStairs {


    public static void main(String[] args) {
        int[] array = new int[]{10, 15, 20};
        int[] array2 = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        System.out.println(minCostClimbingStairs(array2));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return Math.min(helper(cost, n - 2), helper(cost, n - 1));
    }

    public static int helper(int[] cost, int n) {
        if (n < 0)
            return 0;

        if (n == 0)
            return cost[0];
        if (n == 1)
            return cost[1];

        return cost[n] + Math.min(helper(cost, n - 1), helper(cost, n - 2));
    }

}
