package foo;

import java.util.HashMap;
import java.util.Map;

public class Braile {

    public static void main(String[] args) {
        String first = "100100101010100110100010";
        if (solution("code").equals(first))
            System.out.println("GOT");
        else
            System.out.println("NO");
        String second = "000001110000111010100000010100111000111000100010";

        if (solution("Braille").equals(second))
            System.out.println("GOT");
        else
            System.out.println("NO");

        String third = "000001011110110010100010000000111110101001010100100100101000000000110000111010101010010111101110000000110100101010101101000000010110101001101100111100011100000000101010111001100010111010000000011110110010100010000000111000100000101011101111000000100110101010110110";
        if (solution("The quick brown fox jumps over the lazy dog").equals(third))
            System.out.println("GOT");
        else
            System.out.println("NO");
    }

    public static String solution(String s) {
        if (s == null || s.isEmpty())
            return "";
        Map<Character, String> braile = new HashMap<>();
        initMap(braile);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (Character.isLetter(currentChar)) {
                if (Character.isLowerCase(currentChar)) {
                    sb.append(braile.get(currentChar));
                } else {
                    sb.append(braile.get(':'));
                    String value = braile.get(Character.toLowerCase(currentChar));
                    sb.append(value);
                }
            } else if (Character.isSpaceChar(currentChar)) {
                sb.append(braile.get(currentChar));
            }
        }

        return sb.toString();
    }

    public static void initMap(Map<Character, String> map) {
        map.put('a', "100000");
        map.put('b', "110000");
        map.put('c', "100100");
        map.put('d', "100110");
        map.put('e', "100010");
        map.put('f', "110100");
        map.put('g', "110110");
        map.put('h', "110010");
        map.put('i', "010100");
        map.put('j', "010110");
        map.put('k', "101000");
        map.put('l', "111000");
        map.put('m', "101100");
        map.put('n', "101110");
        map.put('o', "101010");
        map.put('p', "111100");
        map.put('q', "111110");
        map.put('r', "111010");
        map.put('s', "011100");
        map.put('t', "011110");
        map.put('u', "101001");
        map.put('v', "111001");
        map.put('w', "010111");
        map.put('x', "101101");
        map.put('y', "101111");
        map.put('z', "101011");
        map.put(':', "000001");
        map.put(' ', "000000");
    }
}
