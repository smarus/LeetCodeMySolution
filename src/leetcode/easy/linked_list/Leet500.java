package leetcode.easy.linked_list;

import java.util.*;

public class Leet500 {
    static HashSet<Character> set1 = new HashSet<>();
    static HashSet<Character> set2 = new HashSet<>();
    static HashSet<Character> set3 = new HashSet<>();

    public static void main(String[] args) {

        String[] string = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        String[] re = findWords(string);

        for (String s : re) {
            System.out.println(s);
        }

    }

    public static String[] findWords(String[] words) {
        set1.add('q');
        set1.add('w');
        set1.add('e');
        set1.add('r');
        set1.add('t');
        set1.add('y');
        set1.add('u');
        set1.add('i');
        set1.add('o');
        set1.add('p');
        set2.add('a');
        set2.add('s');
        set2.add('d');
        set2.add('f');
        set2.add('g');
        set2.add('h');
        set2.add('j');
        set2.add('k');
        set2.add('l');
        set3.add('z');
        set3.add('x');
        set3.add('c');
        set3.add('v');
        set3.add('b');
        set3.add('n');
        set3.add('m');

        List<String> strings = new ArrayList<>();
        String[] copyWords = words.clone();

        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            if (isWord(set1, word) || isWord(set2, word) || isWord(set3, word)) {
                strings.add(copyWords[i]);
            }
        }
        String[] array = new String[strings.size()];
        return strings.toArray(array);
    }

    public static boolean isWord(HashSet set, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!set.contains(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }


}
