package leetcode.easy.arrays;

public class Leet896 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 2, 3};
        int[] array1 = new int[]{6, 5, 4, 4};
        int[] array2 = new int[]{1, 3, 2};
        int[] array3 = new int[]{1, 1, 1};
        System.out.println(isMonotonic(array));
        System.out.println(isMonotonic(array1));
        System.out.println(isMonotonic(array2));
        System.out.println(isMonotonic(array3));
    }

    public static boolean isMonotonic(int[] A) {
        boolean isMonotonic = false;
        if (A.length == 1)
            return true;
        int decOrInc = 0;
        if (A[0] > A[A.length - 1]) {
            decOrInc = 1;
        } else if (A[0] < A[A.length - 1]) {
            decOrInc = 2;
        } else {
            decOrInc = 3;
        }

        if (decOrInc == 1) {
            for (int i = 1; i < A.length; i++) {
                if (A[i - 1] >= A[i]) {
                    isMonotonic = true;
                } else {
                    return false;
                }
            }
        } else if (decOrInc == 2) {
            for (int i = 1; i < A.length; i++) {
                if (A[i - 1] <= A[i]) {
                    isMonotonic = true;
                } else {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < A.length; i++) {
                if (A[i - 1] == A[i]) {
                    isMonotonic = true;
                } else {
                    return false;
                }
            }

        }
        return isMonotonic;
    }
}
