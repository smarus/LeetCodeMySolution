package educative.subset;

import java.util.ArrayList;
import java.util.List;

public class LetterPermutation {
    public static void main(String[] args) {
        List<String> depth = new ArrayList<>();
        depthFirst("ad52", 0, new StringBuilder(), depth);
        System.out.println(depth);

    }

    public static List<String> findLetterCasePermutation(String str) {
        List<String> permutation = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {


        }


        return permutation;
    }

    public static void depthFirst(String str, int index, StringBuilder stringBuilder, List<String> permutation) {
        if (index == str.length()) {
            permutation.add(stringBuilder.toString());
            return;
        } else {
            char[] chars = str.toCharArray();
            if (!Character.isLetter(chars[index]) && Character.isUpperCase(chars[index]))
                chars[index] = (Character.toLowerCase(chars[index]));
            else if (Character.isDigit(chars[index]) && Character.isLowerCase(chars[index]))
                chars[index] = (Character.toUpperCase(chars[index]));
            else
                chars[index] = (chars[index]);
            stringBuilder.append(chars);
            depthFirst(str, index + 1, stringBuilder, permutation);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
