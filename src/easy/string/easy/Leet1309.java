package easy.string.easy;

public class Leet1309 {
    static char[] alfabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't'
            , 'u', 'v', 'w', 'x', 'y', 'z'};

    public static void main(String[] args) {

        System.out.println(freqAlphabets("1326#"));

    }

    public static String freqAlphabets(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = s.length() - 1;
        int number;

        while (true) {
            if (index < 0)
                break;

            if (s.charAt(index) == '#') {
                number = (s.charAt(index - 1) - '0') + (s.charAt(index - 2) - '0') * 10;
                index = index - 3;
            } else {
                number = s.charAt(index) - '0';
                index--;
            }
            stringBuilder.append(alfabet[number - 1]);
        }
        return stringBuilder.reverse().toString();
    }
}
