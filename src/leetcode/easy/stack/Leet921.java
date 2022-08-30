package leetcode.easy.stack;

public class Leet921 {

    public static void main(String[] args) {
        String s = "()))((";
        System.out.println(minAddToMakeValid(s));
    }

    public static int minAddToMakeValid(String S) {
        int left = 0;
        int right = 0;

        for (char c : S.toCharArray()) {
            if (c == '(')
                left++;
            else {
                if (left > 0)
                    left--;
                else
                    right++;
            }
        }
        return right + left;
    }
}
