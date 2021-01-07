package easy.string.easy;

public class Leet242 {
    public static void main(String[] args) {
        System.out.println(isAnagram("a", "ab"));
    }

    public static boolean isAnagram(String s, String t) {
        int[] alfabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alfabet[s.charAt(i) - 'a']++;
            System.out.println(s.charAt(i) - 'a');
        }
        for (int i = 0; i < s.length(); i++) {
            alfabet[t.charAt(i) - 'a']--;
            System.out.println(s.charAt(i) - 'a');

        }

        for (int i = 0; i < 26; i++) {
            if (alfabet[i] != 0) {
                return false;
            }

        }
        return true;
    }
}
