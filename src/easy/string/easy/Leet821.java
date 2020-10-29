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
        int lastIndex = S.length() - 1;
        int index = 0;
        String sb = new StringBuilder(S).reverse().toString();
        System.out.println(sb);
        int[] indexes = new int[S.length()];
        for (int i = 0; i < S.length() / 2; i++) {
            count = S.indexOf(C, i) - i;
            last = sb.indexOf(C, i) - i;
            System.out.println(last + " " + count);
            indexes[index] = count;
            indexes[lastIndex] = last;
            lastIndex--;
            index++;
        }

        return indexes;
    }


}
