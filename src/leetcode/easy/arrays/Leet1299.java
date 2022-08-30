package leetcode.easy.arrays;

public class Leet1299 {
    public static void main(String[] args) {

    }

    // Replace Elements with Greatest Element on Right Side

    public int[] replaceElements(int[] arr) {
        int maxSoFar = arr[arr.length - 1]; //take last element in array as maxVal
        arr[arr.length - 1] = -1;
        //start array traversal from right to left
        for (int i = arr.length - 2; i > -1; i--) {
            int currVal = arr[i];
            arr[i] = maxSoFar;
            maxSoFar = Math.max(maxSoFar, currVal);
            //keep updating maxRight element encountered so far
        }
        return arr;
    }
}
