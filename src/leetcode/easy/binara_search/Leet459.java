package leetcode.easy.binara_search;

public class Leet459 {
    public static void main(String[] args) {
//        System.out.println(repeatedSubstringPattern("abab"));
//        System.out.println(repeatedSubstringPattern("aba"));
//        System.out.println(repeatedSubstringPattern("ababba"));
//        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(repeatedSubstringPattern("abaababaab"));
    }


    //Solved with help
    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int half = n / 2;

        for (int i = 0; i < half; i++) {

            if (n % (i + 1) != 0) continue;

            int l = 0;
            int r = i + 1;

            while (s.charAt(l) == s.charAt(r)) {
                if (r == s.length() - 1) return true;
                r++;
                l = (l + 1) % (i + 1);
            }

        }

        return false;

    }
}

//
//    public static boolean repeatedSubstringPattern(String s) {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if (!ifContains(s.charAt(i), stringBuilder.toString())) {
//                stringBuilder.append(s.charAt(i));
//            }
//        }
//
//        if (s.length() % stringBuilder.length() != 0)
//            return false;
//
//        int subStrLen = stringBuilder.length();
//        int count = 0;
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            sb.append(s.charAt(i));
//            count++;
//            if (count == subStrLen) {
//                if (!checkSubString(stringBuilder.toString(), sb.toString()))
//                    return false;
//                count = 0;
//                sb.setLength(0);
//            }
//
//
//        }
//
//        return true;
//    }
//
//    static boolean ifContains(char c, String s) {
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == c)
//                return true;
//        }
//        return false;
//    }
//
//    static boolean checkSubString(String str1, String str2) {
//
//        System.out.println(str1 + " : " + str2);
//        for (int i = 0; i < str1.length(); i++) {
//            if (str1.charAt(i) != str2.charAt(i))
//                return false;
//        }
//        return true;
//    }
//}
