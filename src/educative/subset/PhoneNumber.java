package educative.subset;

import java.util.ArrayList;
import java.util.List;

//Input: digits = "23"
//        Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//        Example 2:
//
//        Input: digits = ""
//        Output: []
//        Example 3:
//
//        Input: digits = "2"
//        Output: ["a","b","c"]
public class PhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations(""));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> combination = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return combination;

        char[] buffer = new char[digits.length()];
        generateNumbers(buffer, 0, digits, 0, combination);
        return combination;
    }

    public static void generateNumbers(char[] buffer, int bufferIndex, String digits, int digitIndex, List<String> combination) {
        if (bufferIndex == buffer.length) {
            combination.add(String.valueOf(buffer));
            return;
        }

        if (digitIndex == digits.length())
            return;

        char[] letters = getLetters(digits.charAt(digitIndex) - '0');

        if (letters.length == 0)
            generateNumbers(buffer, bufferIndex, digits, digitIndex + 1, combination);
        else {
            for (char letter : letters) {
                buffer[bufferIndex] = letter;
                generateNumbers(buffer, bufferIndex + 1, digits, digitIndex + 1, combination);
            }
        }
    }

    public static char[] getLetters(int digit) {
        switch (digit) {
            case 0:
                return new char[]{};
            case 1:
                return new char[]{};
            case 2:
                return new char[]{'a', 'b', 'c'};
            case 3:
                return new char[]{'d', 'e', 'f'};
            case 4:
                return new char[]{'g', 'h', 'i'};
            case 5:
                return new char[]{'j', 'k', 'l'};
            case 6:
                return new char[]{'m', 'n', 'o'};
            case 7:
                return new char[]{'p', 'q', 'r', 's'};
            case 8:
                return new char[]{'t', 'u', 'v'};
            case 9:
                return new char[]{'w', 'x', 'y', 'z'};
            default:
                throw new IllegalArgumentException();
        }
    }
}
