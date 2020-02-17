package easy.string.easy;

public class Leet824 {
    public static void main(String[] args) {
        String s = "I speak Goat Latin";
        String s2 = "The quick brown fox jumped over the lazy dog";
        System.out.println(toGoatLatin(s));
        System.out.println(toGoatLatin(s2));

    }

    public static String toGoatLatin(String S) {
        String[] string = S.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length; i++) {
            sb.append(convertToGoat(string[i], i + 1));
            if (i != string.length - 1) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    private static StringBuilder convertToGoat(String s, int index) {
        StringBuilder sb = new StringBuilder();
        if (s.charAt(0) == 'a' || s.charAt(0) == 'u' || s.charAt(0) == 'e' || s.charAt(0) == 'o' || s.charAt(0) == 'i' ||
                s.charAt(0) == 'A' || s.charAt(0) == 'U' || s.charAt(0) == 'E' || s.charAt(0) == 'O' || s.charAt(0) == 'I') {
            sb.append(s);
        } else {
            sb.append(s.substring(1));
            sb.append(s.charAt(0));
        }
        sb.append("ma");
        int i = 0;
        while (i != index) {
            sb.append('a');
            i++;
        }
        return sb;
    }
}
