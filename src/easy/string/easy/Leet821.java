package easy.string.easy;

import java.util.Arrays;

public class Leet821 {
    public static void main(String[] args) {
        String S = "loveleetcode";
        char C = 'e';

        System.out.println(Arrays.toString(shortestToChar(S, C)));
    }
    public static int[] shortestToChar(String S, char C) {

        int count = 1;
        int last = 1;
        int index = 0;
        String sb = new StringBuilder(S).reverse().toString();
        int[] indexes = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            count = S.indexOf(C, i) - i;
            indexes[index] = count;
            index++;
        }

        System.out.println(Arrays.toString(indexes) + " 1");
        for (int i = 0; i < sb.length(); i++) {
            count = sb.indexOf(C, i) - i;
            System.out.println(count);
            if (count < indexes[i]) {
                indexes[i] = count;
            }
        }
        System.out.println(Arrays.toString(indexes) + " 2");


        return indexes;
    }


}
