package leetcode.easy;

public class Leet942 {
    public static void main(String[] args) {

        System.out.println(diStringMatch("IDID"));
        System.out.println(diStringMatch("III"));
        System.out.println(diStringMatch("DDI"));
    }

    public static int[] diStringMatch(String S) {
        int sLen = S.length();
        int dec = 0;
        int inc = sLen;
        int[] res = new int[sLen + 1];
        for (int i = sLen - 1; i >= 0; i--) {
            if (S.charAt(i) == 'D') res[i + 1] = dec++;
            else res[i + 1] = inc--;
        }
        res[0] = dec;

        return res;
    }
}
