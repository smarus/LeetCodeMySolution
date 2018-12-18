package easy;

public class Leet922 {

    public static void main(String[] args) {


    }

    public static int[] sortArrayByParityII(int[] A) {
        int[] sort = new int[A.length];
        int odd = 1, even = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                sort[even] = A[i];
                even += 2;
            } else {
                sort[odd] = A[i];
                odd += 2;
            }
        }
        return sort;
    }
}
