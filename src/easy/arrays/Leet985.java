package easy.arrays;

//We have an array A of integers, and an array queries of queries.
//
//For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].
// Then, the answer to the i-th query is the sum of the even values of A.
//
//(Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)
//
//Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.


public class Leet985 {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4};
        int[][] queries = new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};


    }

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int S = 0;
        for (int x : A)
            if (x % 2 == 0)
                S += x;

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; ++i) {
            int val = queries[i][0], index = queries[i][1];
            if (A[index] % 2 == 0) S -= A[index];
            A[index] += val;
            if (A[index] % 2 == 0) S += A[index];
            ans[i] = S;
        }

        return ans;
    }

}
