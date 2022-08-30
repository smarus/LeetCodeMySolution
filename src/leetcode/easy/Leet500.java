package leetcode.easy;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.List;

public class Leet500 {
    public static void main(String[] args) {

    }

    public String[] findWords(String[] words) {
        char[] row_1 = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'};
        char[] row_2 = {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'};
        char[] row_3 = {'Z', 'X', 'C', 'V', 'B', 'N', 'M'};
        List<String> lsit = new ArrayList<>();

//        for (String item : words) {
//            String upperItem = item.toUpperCase();
//            char c = upperItem.charAt(0);
//            if (contains(c, row_1)) {
//                for (char symbol : upperItem.toCharArray()) {
//                    if (!contains(symbol, row_1)) {
//                        break;
//                    }
//                }
//            }
//        }
        return null;
    }




    boolean contains(char c, char[] chars) {

        for (int i = 0; i < chars.length; i++) {
            if (c == chars[i]) {
                return true;
            }
        }
        return false;
    }

}
