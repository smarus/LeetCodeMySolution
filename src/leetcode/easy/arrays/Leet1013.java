package leetcode.easy.arrays;


//Given an array A of integers, return true if and only if
//        we can partition the array into three non-empty parts with equal sums.
//        Formally, we can partition the array if we can
//        find indexes i+1 < j with (A[0] + A[1] + ... + A[i]
//        == A[i+1] + A[i+2] + ... + A[j-1]
//        == A[j] + A[j-1] + ... + A[A.length - 1])

//Input: [0,2,1,-6,6,-7,9,1,2,0,1]
//        Output: true
//        Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1

//Input: [0,2,1,-6,6,7,9,-1,2,0,1]
//        Output: false
//
//        Input: [3,3,6,5,-2,2,5,1,-9,4]
//        Output: true
//        Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
public class Leet1013 {
    public static void main(String[] args) {

    }


    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0) return false;
        int part = sum / 3;
        int count = 0;

        int temp = 0;
        for (int i = 0; i < A.length; i++) {
            temp += A[i];

            if (temp == part && count < 3) {
                temp = 0;
                count++;
            }
        }
        return count == 3;
    }
}
