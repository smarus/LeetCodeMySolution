package leetcode.easy.bit_operation;

public class Leet389 {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";

        System.out.println(findTheDifference(s, t));

    }

    public static char findTheDifference(String s, String t) {
        int c = 0;

        for (char c1 : s.toCharArray())
            c = c ^ c1;

        for (char c2 : t.toCharArray())
            c = c ^ c2;

        return (char) c;
    }
}
