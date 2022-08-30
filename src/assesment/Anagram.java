package assesment;

import java.util.*;

public class Anagram {

    Map<String, Integer> gropsOfAnagram = new HashMap();
    int index = 0;

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> anagrams = anagram.groupAnagrams(strings);
        System.out.println(anagrams);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagram = new ArrayList();

        if (strs == null || strs.length == 0)
            return anagram;

        for (String str : strs) {
            sortandPut(str);
        }

        int i = 0;
        while (i < gropsOfAnagram.size()) {
            anagram.add(new ArrayList());
            i++;
        }

        for (String str : strs) {
            int index = getIndex(str);
            anagram.get(index).add(str);
        }


        return anagram;


    }

    public int getIndex(String word) {
        char[] sortedChar = word.toCharArray();
        Arrays.sort(sortedChar);
        word = new String(sortedChar);
        return gropsOfAnagram.get(word);
    }


    public void sortandPut(String word) {
        char[] sortedChar = word.toCharArray();
        Arrays.sort(sortedChar);
        word = new String(sortedChar);
        if (!gropsOfAnagram.containsKey(word)) {
            gropsOfAnagram.put(word, index);
            index++;
        }
    }
}

