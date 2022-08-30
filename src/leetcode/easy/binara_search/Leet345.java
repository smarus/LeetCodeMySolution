package leetcode.easy.binara_search;

public class Leet345 {
    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("leetcode"));

    }

    public static String reverseVowels(String s) {
        char[] chars = new char[s.length()];
        int n = 0;
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' ||
                    s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' ||
                    s.charAt(i) == 'O' || s.charAt(i) == 'U') {
                chars[n++] = s.charAt(i);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' ||
                    s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' ||
                    s.charAt(i) == 'O' || s.charAt(i) == 'U') {
                sb.append(chars[--n]);
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();


    }
}
