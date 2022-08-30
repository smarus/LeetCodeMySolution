package leetcode.easy.two_pointer;

public class Leet844 {
    public static void main(String[] args) {
        String s = "ad#c";
        String s1 = "ab#c";
        String s2 = "ab##";
        String s4 = "c#d#";
        String s5 = "a#c";
        String s6 = "b";
        System.out.println(backspaceCompare(s, s1));
        System.out.println(backspaceCompare(s2, s4));
        System.out.println(backspaceCompare(s5, s6));
    }

    public static boolean backspaceCompare(String S, String T) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        convertString(S, sb);
        convertString(T, sb2);
        System.out.println(sb);
        System.out.println(sb2);
        return sb.toString().equals(sb2.toString());
    }

    public static void convertString(String s, StringBuilder builder) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (builder.length() > 0 && i != 0)
                    builder.deleteCharAt(builder.length() - 1);
            } else
                builder.append(s.charAt(i));
        }
    }

// best solution
//   class Solution {
//    public boolean backspaceCompare(String S, String T) {
//        int i = S.length()-1;
//        int j = T.length()-1;
//        int countS = 0;
//        int countT = 0;
//        while (i >= 0 || j >= 0) {
//            while (i >= 0 && (countS > 0 || S.charAt(i) == '#')) {
//                if (S.charAt(i) == '#') countS++;
//                else countS--;
//                i--;
//            }
//            char left = i < 0 ? '@' : S.charAt(i);
//            while (j >= 0 && (countT > 0 || T.charAt(j) == '#')) {
//                if (T.charAt(j) == '#') countT++;
//                else countT--;
//                j--;
//            }
//            char right = j < 0 ? '@' : T.charAt(j);
//            if (left != right) return false;
//            i--;
//            j--;
//        }
//        return true;
//    }
//}
}
