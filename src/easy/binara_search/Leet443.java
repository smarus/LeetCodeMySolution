package easy.binara_search;

import java.util.Arrays;

public class Leet443 {
    public static void main(String[] args) {
        //char []chars = new char[]{'a','a','b','b','c','c','c'};
        char[] chars3 = new char[]{'a', 'a', 'a', 'b', 'b', 'a', 'a'};
        // char[] chars2 = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};


        //    System.out.println(compress(chars));
        System.out.println(compress(chars3));
        //  System.out.println(Arrays.toString(chars));
    }

    //Solved by help please read  with attention
    public static int compress(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c : ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }
}
//    public static int compress(char [] chars){
//        if (chars.length == 1)
//            return 1;
//    int count = 0;
//    int genCount = 0;
//        for (int i = 1; i <chars.length ; i++) {
//        if (chars[i - 1] == chars[i]){
//            count++;
//            if (chars.length - 1 == i && count != 0){
//                genCount++;
//                if (count < 10)
//                    genCount+=1;
//                else if (count < 100)
//                    genCount+=2;
//            }
//        } else if (chars[i - 1] != chars[i] || (chars.length - 1) == i){
//            if (count == 0){
//                genCount += 1;
//            }else if (count > 0){
//                genCount += 1;
//                if (count < 10){
//                    genCount++;
//                }else if (count < 100){
//                    genCount += 2;
//                }else if (count<1000){
//                    genCount +=3;
//                }
//                System.out.println(count +" symbol " + chars[i-1]);
//                count = 0;
//            }
//        }
//    }
//        return genCount;
//}
//
//}


//    public static int compress(char[] chars) {
//
//        if (chars.length == 1)
//            return 1;
//
//        int[] alp = new int[91];
//        for (int i = 0; i < chars.length; i++) {
//            alp[chars[i] - '#']++;
//        }
//
//
//        int count = 0;
//
//        for (int i = 0; i < alp.length; i++) {
//            if (alp[i] != 0) {
//                if (alp[i] < 10) {
//                    if (alp[i] == 1) {
//                        chars[count] = (char) (i + '#');
//                        count++;
//                    } else {
//                        chars[count] = (char) (i + '#');
//                        chars[count + 1] = (char) (alp[i] + '0');
//                        count += 2;
//                    }
//                } else if (alp[i] > 9 && alp[i] < 99) {
//                    chars[count] = (char) (i + '#');
//                    chars[count + 1] = (char) (alp[i] / 10 + '0');
//                    chars[count + 2] = (char) (alp[i] % 10 + '0');
//                    count += 3;
//                }
//            }
//        }
//        char[] chars2 = new char[count];
//
//        for (int i = 0; i < count; i++) {
//            chars2[i] = chars[i];
//        }
//        chars = new char[count];
//        for (int i = 0; i < chars.length; i++) {
//            chars[i] = chars2[i];
//        }
//        return chars.length;
//
//    }
