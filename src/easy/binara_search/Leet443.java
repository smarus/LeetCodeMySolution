package easy.binara_search;

import java.util.Arrays;

public class Leet443 {
    public static void main(String[] args) {
        //   char []chars = new char[]{'a','a','b','b','c','c','c'};
        char[] chars2 = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};


        //    System.out.println(compress(chars));
        System.out.println(compress(chars2));
        //  System.out.println(Arrays.toString(chars));
        compress(chars2);
        System.out.println(Arrays.toString(chars2));
    }

    public static int compress(char[] chars) {

        if (chars.length == 1)
            return 1;

        int[] alp = new int[91];
        for (int i = 0; i < chars.length; i++) {
            alp[chars[i] - '#']++;
        }


        int count = 0;

        for (int i = 0; i < alp.length; i++) {
            if (alp[i] != 0) {
                if (alp[i] < 10) {
                    if (alp[i] == 1) {
                        chars[count] = (char) (i + '#');
                        count++;
                    } else {
                        chars[count] = (char) (i + '#');
                        chars[count + 1] = (char) (alp[i] + '0');
                        count += 2;
                    }
                } else if (alp[i] > 9 && alp[i] < 99) {
                    chars[count] = (char) (i + '#');
                    chars[count + 1] = (char) (alp[i] / 10 + '0');
                    chars[count + 2] = (char) (alp[i] % 10 + '0');
                    count += 3;
                }
            }
        }
        char[] chars2 = new char[count];

        for (int i = 0; i < count; i++) {
            chars2[i] = chars[i];
        }
        chars = new char[count];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = chars2[i];
        }
        return chars.length;

    }
}
