package leetcode.easy.string.easy;

public class Leet1796 {

    int[] num = new int[10];

    public static void main(String[] args) {

    }

    public int secondHighest(String s) {

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int index = s.charAt(i) - '0';
                num[index]++;
            }
        }
        int lastindex = -1;
        for (int i = 0; i < num.length; i++) {
            if (num[i] != 0) {
                lastindex = i;
            }
        }


        for (int i = lastindex - 1; i >= 0; i--) {
            if (num[i] != 0) {
                return i;
            }
        }
        return -1;
    }


}
