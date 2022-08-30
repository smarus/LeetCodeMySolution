package leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles {

//    Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
//    Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]


    public static void main(String[] args) {
        String[] logs = new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};

        System.out.println(Arrays.toString(reorderLogFiles(logs)));

        System.out.println(Arrays.toString("fff fdf 34ff gfjgf".split(" ", 3)));

    }


//    The letter-logs come before all digit-logs.
//    The letter-logs are sorted lexicographically by their contents.
//    If their contents are the same, then sort them lexicographically by their identifiers.
//    The digit-logs maintain their relative ordering.

    // 1
    // 0
    // -1
    public static String[] reorderLogFiles(String[] log) {

        Comparator<String> customComparator = new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {

                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                if (!isDigit1 && !isDigit2) {
                    int compare = split1[1].compareTo(split2[1]);
                    if (compare != 0)
                        return compare;

                    compare = split1[0].compareTo(split2[0]);
                    return compare;
                } else if (!isDigit1 && isDigit2) {
                    return -1;
                } else if (isDigit1 && !isDigit2)
                    return 1;
                return 0;
            }
        };
        Arrays.sort(log, customComparator);
        return log;
    }

}
